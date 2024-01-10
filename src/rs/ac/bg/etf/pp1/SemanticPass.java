package rs.ac.bg.etf.pp1;

import org.apache.log4j.Logger;
import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;

import java.util.*;

public class SemanticPass extends VisitorAdaptor {
    Obj currentMethod = null;

    Stack<Obj> calledMethods = new Stack<>();

    List<Struct> currentActParams = new ArrayList<>();

    List<Obj> designatorHelperList = new ArrayList<>();
    boolean returnFound = false;
    boolean errorDetected = false;
    int nVars;

    boolean mainMethod = false;

    String currentNamespace = null;

    Struct currentType = null;

    boolean isArray = false;

    boolean arrayIndexing = false;

    int forLoopDetectedCounter = 0;

    Logger log = Logger.getLogger(getClass());

    public void report_error(String message, SyntaxNode info) {
        errorDetected = true;
        StringBuilder msg = new StringBuilder(message);
        int line = (info == null) ? 0: info.getLine();
        if (line != 0)
            msg.append (" - Semanticka greska na liniji ").append(line);
        log.error(msg.toString());
    }

    public void report_info(String message, SyntaxNode info) {
        StringBuilder msg = new StringBuilder(message);
        int line = (info == null) ? 0: info.getLine();
        if (line != 0)
            msg.append (" na liniji ").append(line);
        log.info(msg.toString());
    }

    //Program
    public void visit(ProgName progName){
        progName.obj = TabDerived.insert(Obj.Prog, progName.getProgName(), TabDerived.noType);
        TabDerived.openScope();
        TabDerived.insert(Obj.Var,"$spec_iterator$",TabDerived.intType);
    }

    @Override
    public void visit(Program program) {
        nVars = TabDerived.currentScope.getnVars();
        if(!mainMethod){
            report_error("Ne postoji main funkcija deklarisana u okviru programa",program);
        }
        TabDerived.chainLocalSymbols(program.getProgName().obj);
        TabDerived.closeScope();
    }

    //Namespace processing

    public void visit(NamespaceName namespaceName){
        currentNamespace = namespaceName.getNamespaceName();
    }

    public void visit(Namespace namespace){
        currentNamespace = null;
    }

    //Const

     @Override
     public void visit(ConstDecl constDecl){
        //check for namespace
         String constName = constDecl.getConstName();
         if(currentNamespace!=null){
             constName = currentNamespace + "::" + constName;
         }
        //check type constraint
         if(!currentType.equals(constDecl.getLiteral().obj.getType())){
             report_error("Deklarisani tip konstante nije isti kao tip literala koji joj se dodeljuje",constDecl);
             currentType= null;
             return;
         }
        //check for multiple declarations in same scope
         Obj found = TabDerived.find(constName);
         if(found!=TabDerived.noObj){
             report_error("Deklarisano ime konstante vec postoji",constDecl);
             return;
         }

         Obj constInserted = TabDerived.insert(Obj.Con, constName,constDecl.getLiteral().obj.getType());
         constInserted.setAdr(constDecl.getLiteral().obj.getAdr());
         currentType= null;
     }

    public void visit(MultipleConstDecls multipleConstDecls){
        //check for namespace
        String constName = multipleConstDecls.getConstName();
        if(currentNamespace!=null){
            constName = currentNamespace + "::" + constName;
        }
        //check type constraint
        if(!currentType.equals(multipleConstDecls.getLiteral().obj.getType())){
            report_error("Deklarisani tip konstante nije isti kao tip literala koji joj se dodeljuje",multipleConstDecls);
            return;
        }
        //check for multiple declarations in same scope
        Obj found = TabDerived.find(constName);
        if(found!=TabDerived.noObj){
            report_error("Deklarisano ime konstante vec postoji",multipleConstDecls);
            return;
        }

        Obj constInserted = TabDerived.insert(Obj.Con, constName ,multipleConstDecls.getLiteral().obj.getType());
        constInserted.setAdr(multipleConstDecls.getLiteral().obj.getAdr());
    }
     @Override public void visit(LiteralNUM literalNUM){
            Obj valueNode = new Obj(Obj.Con, "",TabDerived.intType);
            valueNode.setAdr(literalNUM.getValue());
            literalNUM.obj = valueNode;
     }

    @Override
    public void visit(LiteralBOOL literalBOOL){
        Obj valueNode = new Obj(Obj.Con, "",TabDerived.boolType);
        valueNode.setAdr(literalBOOL.getValue()==true?1:0);
        literalBOOL.obj = valueNode;
    }

    @Override
    public void visit(LiteralCHAR literalCHAR){
        Obj valueNode = new Obj(Obj.Con, "",TabDerived.charType);
        valueNode.setAdr(literalCHAR.getValue());
        literalCHAR.obj = valueNode;
    }

    //Type
    @Override
    public void visit(NormalType normalType) {
        Obj typeNode = TabDerived.find(normalType.getTypeName());
        if(typeNode==TabDerived.noObj){
            report_error("Nije pronadjen tip " + normalType.getTypeName() + " u tabeli simbola ! ", null);
            normalType.struct = TabDerived.noType;
        }
        else {
            if(Obj.Type == typeNode.getKind()){
                normalType.struct = typeNode.getType();
                currentType = normalType.struct;
            }else{
                report_error("Greska: Ime " + normalType.getTypeName() + " ne predstavlja tip!",normalType);
                normalType.struct = TabDerived.noType;
            }
        }
    }

    //Variable declarations

     @Override
     public void visit(VarDeclNormal varDeclNormal){
         //treba da ugasim currentTYpe
         currentType = null;
     }

     public void visit(PossibleArrayDeclYes possibleArrayDeclYes){
        isArray = true;
     }

     public void visit(SingleVar singleVar){
         //check for namespace
         String varName = singleVar.getVarName();
         if(currentNamespace!=null && currentMethod==null){
             varName = currentNamespace + "::" + varName;
         }
        //check variable constraint for name
         Obj var = TabDerived.find(varName);
         if(var!=TabDerived.noObj){
             //check if its in the same scope
             if(TabDerived.currentScope.findSymbol(varName) != null){
                 report_error("Promenljiva sa imenom " + varName + " je vec deklarisana u ovom opsegu",singleVar);
                 isArray = false;
                 return;
             }
         }

        //check if variable is array
        Struct varType = currentType;
        if(isArray){
            varType = new Struct(Struct.Array,currentType);
        }
        report_info("Deklarisana promenljiva "+singleVar.getVarName(),singleVar);
         Obj varNode = TabDerived.insert(Obj.Var, varName, varType);
         isArray = false;
     }

     //parameters processing

    public void visit(FormParam formParam){
        //check if parameter is array
        Struct parType = currentType;
        if(isArray){
            parType = new Struct(Struct.Array,currentType);
        }
        Obj parNode = TabDerived.insert(Obj.Var, formParam.getParamName(), parType);
        parNode.setFpPos(currentMethod.getLevel());
        currentMethod.setLevel(currentMethod.getLevel()+1);
        isArray = false;
        currentType = null;
    }

     //Method declarations

    public void visit(MethodWithType methodWithType){
        //check for main method
        if(methodWithType.getMethodName().equals("main")){
            if(currentType!=null){
                report_error("Funkcija main mora biti deklarisana kao void",methodWithType);
            }
        }
        //check for namespace
        String methName = methodWithType.getMethodName();
        if(currentNamespace!=null){
            methName = currentNamespace + "::" + methName;
        }

        //check method constraint for name
        Obj var = TabDerived.find(methName);
        if(var!=TabDerived.noObj){
            //check if its in the same scope
            if(TabDerived.currentScope.findSymbol(methName) != null){
                report_error("Funkcija sa imenom " + methName + " je vec deklarisana u ovom opsegu",methodWithType);
                return;
            }
        }

        currentMethod = TabDerived.insert(Obj.Meth, methName, currentType);
        currentType = null;
        methodWithType.obj = currentMethod;
        TabDerived.openScope();
        report_info("Obradjuje se metod " + methName, methodWithType);
    }

    public void visit(VoidMethod voidMethod){
        //check for main method
        if(voidMethod.getMethodName().equals("main")){
            if(currentNamespace!=null){
                report_error("Funkcija main mora biti deklarisana u bezimenom prostoru imena",voidMethod);
            }
            mainMethod = true;
        }

        //check for namespace
        String methName = voidMethod.getMethodName();
        if(currentNamespace!=null){
            methName = currentNamespace + "::" + methName;
        }

        //check method constraint for name
        Obj var = TabDerived.find(methName);
        if(var!=TabDerived.noObj){
            //check if its in the same scope
            if(TabDerived.currentScope.findSymbol(methName) != null){
                report_error("Funkcija sa imenom " + methName + " je vec deklarisana u ovom opsegu",voidMethod);
                return;
            }
        }

        currentMethod = TabDerived.insert(Obj.Meth, methName, TabDerived.noType);
        voidMethod.obj = currentMethod;
        TabDerived.openScope();
        report_info("Obradjuje se metod " + methName, voidMethod);
    }

    public void visit(MethodDecl methodDecl){
        methodDecl.obj = methodDecl.getMethodTypeName().obj;
        TabDerived.chainLocalSymbols(currentMethod);
        TabDerived.closeScope();
        returnFound = false;
        currentMethod = null;
    }

    public void visit(DesignatorStmtAssign designatorStmtAssign){
        Obj des = designatorStmtAssign.getDesignator().obj;
        Struct expr = designatorStmtAssign.getExpr().struct;
        if(!expr.assignableTo(des.getType())){
            report_error("Tip izraza nije kompatibilan pri dodeli",designatorStmtAssign);
        }
        if(des.getKind() != Obj.Var && des.getKind() != Obj.Elem){
            report_error("Korisceno ime mora biti promenljiva ili element niza",designatorStmtAssign);
        }
    }

    public void visit(DesignatorStmtMinusMinus designatorStmtMinusMinus){
        Obj des = designatorStmtMinusMinus.getDesignator().obj;
        if(des.getKind() != Obj.Var && des.getKind() != Obj.Elem){
            report_error("Korisceno ime mora biti promenljiva ili element niza",designatorStmtMinusMinus);
        }
    }

    public void visit(DesignatorStmtPlusPlus designatorStmtPlusPlus){
        Obj des = designatorStmtPlusPlus.getDesignator().obj;
        if(des.getKind() != Obj.Var && des.getKind() != Obj.Elem){
            report_error("Korisceno ime mora biti promenljiva ili element niza",designatorStmtPlusPlus);
        }
    }

    public void visit(DesignatorStmtCallNoArg designatorStmtCallNoArg){
        //mora biti globalna funkcija glavnog prog
        Obj des = TabDerived.find(designatorStmtCallNoArg.getDesignator().obj.getName());
        if(des!=TabDerived.noObj){
            if(des.getKind()!=Obj.Meth){
                report_error("Korisceno ime ne predstavlja globalnu funkciju glavnog programa", designatorStmtCallNoArg);
            }else{
                //skinuti metod sa steka
                calledMethods.pop();
            }
        }
    }

    public void visit(DesignatorStmtCallArg designatorStmtCallArg){
        //mora biti globalna funkcija glavnog prog
        Obj des = TabDerived.find(designatorStmtCallArg.getDesignator().obj.getName());
        if(des!=TabDerived.noObj){
            if(des.getKind()!=Obj.Meth){
                report_error("Korisceno ime ne predstavlja globalnu funkciju glavnog programa", designatorStmtCallArg);
            }
            else {
                // skinuti metod sa steka
                // prvo proveriti parametre pa skinuti sa steka
                Obj method = calledMethods.pop();
                //check constraints for params
                if(method.getLevel()!=currentActParams.size()){
                    report_error("Razlicit broj parametara u odnosu na potpis funkcije", designatorStmtCallArg);
                }else{
                    int currentFormalParam = 0;
                    for (Iterator<Obj> formalParsIter = method.getLocalSymbols().iterator();
                          currentFormalParam<method.getLevel() && formalParsIter.hasNext();){
                        Struct formal = formalParsIter.next().getType();
                        Struct actual = currentActParams.get(currentFormalParam);
                        if(!actual.assignableTo(formal)){
                            report_error("Stvarni argument na poziciji "+ currentActParams + "nije kompatibilan pri dodeli sa formalnim argumentom", designatorStmtCallArg);
                        }
                    }
                    currentActParams.clear();
                }
            }
        }
    }

    public void visit(DesignatorWNamespace designatorWNamespace){
        Obj desObj = TabDerived.find(designatorWNamespace.getNamespace()+"::"+designatorWNamespace.getDesName());
        //check if its declared and it is var, const or method defined in namespace
        if(desObj!=TabDerived.noObj){
            if(desObj.getKind() != Obj.Con && desObj.getKind() != Obj.Var && desObj.getKind() != Obj.Meth){
                report_error("Korisceno ime mora biti konstanta, promenljiva ili metod",designatorWNamespace);
                designatorWNamespace.obj = TabDerived.noObj;
            }
            else{
                designatorWNamespace.obj = desObj;
                if(desObj.getKind()==Obj.Meth){
                    //poziva se metod, staviti ga na stek poziva
                    calledMethods.push(desObj);
                }
            }
        }else{
            report_error("Ne postoji promenljiva ili metod sa imenom "+designatorWNamespace.getDesName() + " deklarisana u " + designatorWNamespace.getNamespace()+ " prostoru imena",designatorWNamespace);
            designatorWNamespace.obj = TabDerived.noObj;
        }
    }

    public void visit(DesignatorWONamespace designatorWONamespace){
        Obj desObj = TabDerived.find(designatorWONamespace.getDesName());
        if(desObj==TabDerived.noObj && currentNamespace!=null){
            desObj = TabDerived.find(currentNamespace+"::"+designatorWONamespace.getDesName());
        }
        //check if its declared and it is var, const or method defined in namespace
        if(desObj!=TabDerived.noObj){
            if(desObj.getKind() != Obj.Con && desObj.getKind() != Obj.Var && desObj.getKind() != Obj.Meth){
                report_error("Korisceno ime mora biti konstanta, promenljiva ili metod",designatorWONamespace);
                designatorWONamespace.obj = TabDerived.noObj;
            }
            else{
                designatorWONamespace.obj = desObj;
                if(desObj.getKind()==Obj.Meth){
                    //poziva se metod, staviti ga na stek poziva
                    calledMethods.push(desObj);
                }
            }
        }else{
            report_error("Ne postoji deklarisana promenljiva ili metod sa imenom "+designatorWONamespace.getDesName(), designatorWONamespace);
            designatorWONamespace.obj = TabDerived.noObj;
        }
    }

    public void visit(DesignatorArrayName designatorArrayName){
        //move Expr value and Type to Designator to check
        arrayIndexing = true;
    }

    public void visit(DesignatorArray designatorArray){
        if(designatorArray.getDesignatorArrayName().getDesignator().obj.getType().getKind() !=Struct.Array){
            report_error("Promenljiva ne predstavlja niz",designatorArray);
            designatorArray.obj = TabDerived.noObj;
        }

        if(!designatorArray.getExpr().struct.equals(TabDerived.intType)){
            report_error("Indeks niza mora biti celobrojnog tipa", designatorArray);
            designatorArray.obj = TabDerived.noObj;
        }

        designatorArray.obj = new Obj(Obj.Elem, designatorArray.getDesignatorArrayName().getDesignator().obj.getName(), designatorArray.getDesignatorArrayName().getDesignator().obj.getType().getElemType());


    }

    public void visit(FactorNewArrayExpr factorNewArrayExpr){
        if(!factorNewArrayExpr.getExpr().struct.equals(TabDerived.intType)){
            report_error("Prilikom deklarisanja niza pomocu new, broj elemenata mora biti int", factorNewArrayExpr);
            factorNewArrayExpr.struct = TabDerived.noType;
            return;
        }
        factorNewArrayExpr.struct = new Struct(Struct.Array,factorNewArrayExpr.getType().struct);
    }

    //All productions for method invocation processing

    public void visit(ActParam actParam){
        //this is the first param
        currentActParams.add(actParam.getExpr().struct);
    }

    public void visit(ActParams actParams){
        //rest of params
        currentActParams.add(actParams.getExpr().struct);
    }

    public void visit(FactorCall factorCall){
        Obj func = factorCall.getDesignator().obj;
        if(Obj.Meth == func.getKind()){
            report_info("Pronadjen poziv funkcije " + func.getName() + " na liniji " + factorCall.getLine(), null);
            factorCall.struct = func.getType();
            //skinuti metod sa steka
            Obj method = calledMethods.pop();
            //check constraints for params
            if(method.getLevel()!=currentActParams.size()){
                report_error("Razlicit broj parametara u odnosu na potpis funkcije", factorCall);
            }else{
                int currentFormalParam = 0;
                for (Iterator<Obj> formalParsIter = method.getLocalSymbols().iterator();
                     currentFormalParam<method.getLevel() && formalParsIter.hasNext();){
                    Struct formal = formalParsIter.next().getType();
                    Struct actual = currentActParams.get(currentFormalParam);
                    if(!actual.assignableTo(formal)){
                        report_error("Stvarni argument na poziciji "+ currentFormalParam + " prilikom poziva funkcije "+ method.getName()+ " nije kompatibilan pri dodeli sa formalnim argumentom", factorCall);
                    }
                    currentFormalParam++;
                }
                currentActParams.clear();
            }
        }else{
            report_error("Ime " + func.getName() + "nije funkcija !", factorCall);
        }
    }

    @Override
    public void visit(TermMulop termMulop) {
        if(termMulop.getTerm().struct.equals(TabDerived.intType) && termMulop.getFactor().struct.equals(TabDerived.intType)){
            //ok
            termMulop.struct = termMulop.getTerm().struct;
        }else{
            report_error("Oba cinioca moraju biti tipa int", termMulop);
            termMulop.struct = TabDerived.noType;
        }
    }

    public void visit(GeneralExpr generalExpr){
        if(generalExpr.getTerm().struct.equals(TabDerived.intType) && generalExpr.getTerm().struct.equals(TabDerived.intType)){
            //ok, give Expr type
            generalExpr.struct = generalExpr.getExpr().struct;
        }else{
            report_error("Izrazi koji se sabiraju moraju biti int tipa", generalExpr);
            generalExpr.struct = TabDerived.noType;
        }
    }

    public void visit(ExprMinusTerm exprMinusTerm){
        if(!exprMinusTerm.getTerm().struct.equals(TabDerived.intType)){
            report_error("Deo izraza posle znaka - mora biti integer tipa",exprMinusTerm);
            exprMinusTerm.struct = TabDerived.noType;
            return;
        }
        exprMinusTerm.struct = exprMinusTerm.getTerm().struct;
    }

    public void visit(ExprTerm exprTerm){
        exprTerm.struct = exprTerm.getTerm().struct;
    }

    public void visit(FactorChar factorChar){
        factorChar.struct = TabDerived.charType;
    }

    public void visit(FactorBool factorBool){
        factorBool.struct = TabDerived.boolType;
    }

    public void visit(FactorNum factorNum){
        factorNum.struct = TabDerived.intType;
    }

    public void visit(TermFactor termFactor){
        termFactor.struct = termFactor.getFactor().struct;
    }

    public void visit(FactorDesignator factorDesignator){
        factorDesignator.struct = factorDesignator.getDesignator().obj.getType();
    }

    public void visit(RelopCondFact relopCondFact){
        Struct e1 = relopCondFact.getExpr1().struct;
        Struct e2 = relopCondFact.getExpr().struct;
        if(!e1.compatibleWith(e2)){
            report_error("Tipovi izraza nisu kompatibilni", relopCondFact);
            relopCondFact.struct = TabDerived.noType;
            return;
        }
        if(e1.getKind() == Struct.Array || e1.getKind() == Struct.Array){
//            if(relopCondFact.getRelop().struct.getKind() != Code.eq || relopCondFact.getRelop().struct.getKind() != Code.ne) {
//                report_error("Korisceni tipovi izraza smeju koristiti samo relacione operatore == ili !=", relopCondFact);
//                relopCondFact.struct = TabDerived.noType;
//                return;
//            }
        }
        relopCondFact.struct = TabDerived.boolType;
    }

//    public void visit(NormalCondFact normalCondFact){
//        if(!normalCondFact.getExpr().struct.equals(TabDerived.boolType)){
//            report_error("Izraz mora biti boolean tipa da bi se koristio u uslovnim operacijama",normalCondFact);
//            normalCondFact.struct = TabDerived.noType;
//            return;
//        }
//        normalCondFact.struct = normalCondFact.getExpr().struct;
//    }
//
//    public void visit(NormalCondTerm normalCondTerm){
//        normalCondTerm.struct = normalCondTerm.getCondFact().struct;
//    }
//
//    public void visit(CondTermBITAND condTermBITAND){
//        condTermBITAND.struct = TabDerived.boolType;
//    }
//
//    public void visit(NormalCondition normalCondition){
//        normalCondition.struct = normalCondition.getCondTerm().struct;
//    }
//
//    public void visit(ConditionBITOR conditionBITOR){
//        conditionBITOR.struct = TabDerived.boolType;
//    }
//
//    public void visit(RelopEQUAL relopEQUAL){
//        relopEQUAL.struct = new Struct(Code.eq);
//    }
//
//    public void visit(RelopNOTEQUAL relopNOTEQUAL){
//        relopNOTEQUAL.struct = new Struct(Code.ne);
//    }
//
//    public void visit(RelopGRT relopGRT){
//        relopGRT.struct = new Struct(Code.gt);
//    }
//
//    public void visit(RelopGRTE relopGRTE){
//        relopGRTE.struct = new Struct(Code.ge);
//    }
//
//    public void visit(RelopLSS relopLSS){
//        relopLSS.struct = new Struct(Code.lt);
//    }
//
//    public void visit(RelopLSSE relopLSSE){
//        relopLSSE.struct = new Struct(Code.le);
//    }

    //ForLoop
    public void visit(ForLoopStart forLoopStart){
        forLoopDetectedCounter++;
    }

    public void visit(StatementForLoop statementForLoop){
        forLoopDetectedCounter--;
    }

    public void visit(FactorParenExpr factorParenExpr){
        factorParenExpr.struct = factorParenExpr.getExpr().struct;
    }
    //Statements
    public void visit(StatementBreak statementBreak){
        if(forLoopDetectedCounter==0){
            report_error("Iskaz break se moze koristiti samo unutar for petlje", statementBreak);
        }
    }

    public void visit(StatementContinue statementContinue){
        if(forLoopDetectedCounter==0){
            report_error("Iskaz continue se moze koristiti samo unutar for petlje", statementContinue);
        }
    }

    public void visit(StatementRead statementRead){
        Obj des = statementRead.getDesignator().obj;
        if(des.getKind() != Obj.Var && des.getKind() != Obj.Elem){
            report_error("Korisceno ime mora biti promenljiva ili element niza",statementRead);
        }
        if(!des.getType().equals(TabDerived.intType) && !des.getType().equals(TabDerived.boolType) && !des.getType().equals(TabDerived.charType)){
            report_error("Korisceno ime u metodi read mora biti tipa int, char ili bool", statementRead);
        }
    }

    public void visit(StatementPrintSingle statementPrintSingle){
        Struct e = statementPrintSingle.getExpr().struct;
        if(!e.equals(TabDerived.intType) && !e.equals(TabDerived.boolType) && !e.equals(TabDerived.charType)){
            report_error("Korisceno ime u metodi print mora biti tipa int, char ili bool", statementPrintSingle);
        }
    }

    public void visit(StatementPrintMultiple statementPrintMultiple){
        Struct e = statementPrintMultiple.getExpr().struct;
        if(!e.equals(TabDerived.intType) && !e.equals(TabDerived.boolType) && !e.equals(TabDerived.charType)){
            report_error("Korisceno ime u metodi print mora biti tipa int, char ili bool", statementPrintMultiple);
        }
    }

    public void visit(StatementRetrun statementRetrun){
        //method must be void
        if(currentMethod == null){
            report_error("Naredba return mora se nalaziti u telu funkcije", statementRetrun);
        }
        else if(!currentMethod.getType().equals(TabDerived.noType)){
            report_error("Kod metoda sa povratnim tipom, neophodan je izraz nakon return naredbe", statementRetrun);
        }
    }

    public void visit(StatementReturnExpr statementReturnExpr){
        if(currentMethod == null){
            report_error("Naredba return mora se nalaziti u telu funkcije", statementReturnExpr);
            return;
        }
        else if(!currentMethod.getType().equals(statementReturnExpr.getExpr().struct)){
            report_error("Povratna vrednost ne odgovara deklarisanom povratnom tipu funkcije",statementReturnExpr);
            return;
        }
    }

    //Designator complicate statement
    public void visit(DesignatorStatementMultipleAssign designatorStatementMultipleAssign){
        Obj rightDes = designatorStatementMultipleAssign.getDesignator1().obj;
        Obj leftLast = designatorStatementMultipleAssign.getDesignator().obj;
        if(rightDes.getType().getKind()!=Struct.Array){
            report_error("Promenljiva sa desne strane znaka jednakosti mora biti niz",designatorStatementMultipleAssign);
            return;
        }
        if(leftLast.getType().getKind()!=Struct.Array){
            report_error("Poslednja promenljiva sa leve strane znaka jednakosti(posle *) mora biti niz",designatorStatementMultipleAssign);
            return;
        }
        //check if it is compatible
        if(!rightDes.getType().getElemType().compatibleWith(leftLast.getType().getElemType())){
            report_error("Tip elemenata niza sa leve strane nije kompatibilan pri dodeli sa promenljivom posle *",designatorStatementMultipleAssign);
        }
        for(Obj elem :designatorHelperList){
            if(elem.getKind()!=Obj.Var && elem.getKind()!=Obj.Elem){
                report_error("Svi elementi sa leve strane znaka jednakosti osim poslednjeg moraju oznacavati promenljivu ili element niza", designatorStatementMultipleAssign);
            }
            if(!rightDes.getType().getElemType().assignableTo(elem.getType())){
                report_error("Tip elemenata niza sa desne strane jednakosti nije kompatibilan pri dodeli sa nekim od elemenata sa leve strane znaka jednakosti", designatorStatementMultipleAssign);
            }
        }
        designatorHelperList.clear();
    }

    public void visit(DesignatorYes designatorYes){
        designatorHelperList.add(designatorYes.getDesignator().obj);
        //provera da li uopste postoji u tabeli simbola?
    }

    public boolean passed(){
        return !errorDetected;
    }
}
