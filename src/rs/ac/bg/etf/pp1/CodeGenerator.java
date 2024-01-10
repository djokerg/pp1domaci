package rs.ac.bg.etf.pp1;

import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CodeGenerator extends VisitorAdaptor {
    private int mainPc;
    boolean returnFound = false;
    public int getMainPc(){
        return mainPc;
    }

    public void visit(StatementPrintSingle statementPrintSingle){
        if(statementPrintSingle.getExpr().struct == TabDerived.intType){
            Code.loadConst(5);
            Code.put(Code.print);
        }else{
            Code.loadConst(1);
            Code.put(Code.bprint);
        }
    }

    public void visit(StatementPrintMultiple statementPrintMultiple){
        Code.loadConst(statementPrintMultiple.getN2());
        Code.put(Code.print);
    }

    public void visit(StatementRead statementRead){
        if(statementRead.getDesignator().obj.getType() == TabDerived.charType){
            Code.put(Code.bread);
        }else{
            Code.put(Code.read);
        }
        Code.store(statementRead.getDesignator().obj);
    }

//    public void visit(LiteralNUM literalNUM){
//        Obj con = TabDerived.insert(Obj.Con,"$",TabDerived.intType);
//        con.setLevel(0);
//        con.setAdr(literalNUM.getValue());
//
//        Code.load(con);
//    }
//
//    public void visit(LiteralBOOL literalBOOL){
//        Obj con = TabDerived.insert(Obj.Con,"$",TabDerived.boolType);
//        con.setLevel(0);
//        con.setAdr(literalBOOL.getValue() ?1:0);
//
//        Code.load(con);
//    }
//
//    public void visit(LiteralCHAR literalCHAR){
//        Obj con = TabDerived.insert(Obj.Con,"$",TabDerived.charType);
//        con.setLevel(0);
//        con.setAdr(literalCHAR.getValue());
//
//        Code.load(con);
//    }

    //method

    public void visit(MethodWithType methodWithType){

        if("main".equalsIgnoreCase(methodWithType.getMethodName())){
            mainPc = Code.pc;
        }

        methodWithType.obj.setAdr(Code.pc);
        // Collect arguments and local variables

        // Generate the entry
        Code.put(Code.enter);
        Code.put(methodWithType.obj.getLevel());
        Code.put(methodWithType.obj.getLocalSymbols().size());

    }

    public void visit(VoidMethod voidMethod){
        if("main".equalsIgnoreCase(voidMethod.getMethodName())){
            mainPc = Code.pc;
        }

        voidMethod.obj.setAdr(Code.pc);
        // Collect arguments and local variables

        // Generate the entry
        Code.put(Code.enter);
        Code.put(voidMethod.obj.getLevel());
        Code.put(voidMethod.obj.getLocalSymbols().size());
    }

    public void visit(MethodDecl methodDecl){
        if(methodDecl.obj.getType()!=TabDerived.noType && !returnFound){
//            Code.put(Code.trap);
//            Code.put(1);
        }
        else if(methodDecl.obj.getType()==TabDerived.noType && !returnFound){
            Code.put(Code.exit);
            Code.put(Code.return_);
        }
        returnFound = false;
    }

    public void visit(DesignatorStmtAssign designatorStmtAssign){
        Code.store(designatorStmtAssign.getDesignator().obj);
    }

    public void visit(DesignatorStmtPlusPlus designatorStmtPlusPlus){
        //check this for array elements
        Code.load(designatorStmtPlusPlus.getDesignator().obj);
        Code.loadConst(1);
        Code.put(Code.add);
        Code.store(designatorStmtPlusPlus.getDesignator().obj);
    }

    public void visit(DesignatorStmtMinusMinus designatorStmtMinusMinus){
        Code.load(designatorStmtMinusMinus.getDesignator().obj);
        Code.loadConst(1);
        Code.put(Code.sub);
        Code.store(designatorStmtMinusMinus.getDesignator().obj);
    }

    //Factor productions processing

    public void visit(FactorDesignator factorDesignator){
        Code.load(factorDesignator.getDesignator().obj);
    }

    public void visit(FactorNum factorNum){
        Obj con = TabDerived.insert(Obj.Con,"$",TabDerived.intType);
        con.setLevel(0);
        con.setAdr(factorNum.getNumValue());

        Code.load(con);
    }

    public void visit(FactorBool factorBool){
        Obj con = TabDerived.insert(Obj.Con,"$",TabDerived.boolType);
        con.setLevel(0);
        con.setAdr(factorBool.getBoolValue()?1:0);

        Code.load(con);
    }

    public void visit(FactorChar factorChar){
        Obj con = TabDerived.insert(Obj.Con,"$",TabDerived.intType);
        con.setLevel(0);
        con.setAdr(factorChar.getCharValue());

        Code.load(con);
    }

    public void visit(FactorNewArrayExpr factorNewArrayExpr){
        Code.put(Code.newarray);
        if(factorNewArrayExpr.struct.getElemType()!=TabDerived.charType){
            Code.put(1);
        }else{
            Code.put(0);
        }
    }

    public void visit(ExprMinusTerm exprMinusTerm){
        Code.put(Code.neg);
    }

    public void visit(GeneralExpr generalExpr){
        if(generalExpr.getAddop() instanceof AddopPLUS){
            Code.put(Code.add);
        }else{
            Code.put(Code.sub);
        }
    }

    public void visit(TermMulop termMulop){
        if(termMulop.getMulop() instanceof MulopDIV){
            Code.put(Code.div);
        }else if (termMulop.getMulop() instanceof  MulopMUL){
            Code.put(Code.mul);
        }else{
            Code.put(Code.rem);
        }
    }

    public void visit(DesignatorArrayName designatorArrayName){
        Code.load(designatorArrayName.getDesignator().obj);
    }

    //Generisanje koda za pozive metoda

    public void visit(DesignatorStmtCallArg designatorStmtCallArg){
        int dest_adr = designatorStmtCallArg.getDesignator().obj.getAdr() - Code.pc;
        Code.put(Code.call);
        Code.put2(dest_adr);
        if(designatorStmtCallArg.getDesignator().obj.getType() != Tab.noType){
            Code.put(Code.pop);
        }
    }

    public void visit(DesignatorStmtCallNoArg designatorStmtCallNoArg){
        int dest_adr = designatorStmtCallNoArg.getDesignator().obj.getAdr() - Code.pc;
        Code.put(Code.call);
        Code.put2(dest_adr);
        if(designatorStmtCallNoArg.getDesignator().obj.getType() != Tab.noType){
            Code.put(Code.pop);
        }
    }

    public void visit(StatementReturnExpr statementReturnExpr){
        returnFound = true;
        Code.put(Code.exit);
        Code.put(Code.return_);
    }

    public void visit(StatementRetrun statementRetrun){
        returnFound = true;
        Code.put(Code.exit);
        Code.put(Code.return_);//check this
    }

    public void visit(FactorCall factorCall){
        if("ord".equals(factorCall.getDesignator().obj.getName())){
            return;
        }
        int dest_adr = factorCall.getDesignator().obj.getAdr() - Code.pc;
        Code.put(Code.call);
        Code.put2(dest_adr);
    }

    /*if-else, for statements processing
    * This is my own guidance to conditional branches
    * all progressions for consideration
    * Condition
    * CondTerm || CondTerm
    * CondFact && CondFact
    * Expr Relop Expr
    *
    * When || is processed, i have to jump from one condition to another, so i use putJmp, but for last || i use putFalse, because if it is false, i have to jump to else
    *
    * When && is processed, i have to jump from whole (&&) to another (||) if it is false, so i use putJmpFalse, if it is last &&, i have to jump to else
    *
    * I have to determine when to jump to else and when not to jump
    *
    * When whole condition in if statement is processed, i have to go to then statement
    * also after whole condition, i putFalse jump which will be patched to jump on else
    *
    * after last AND, i have to jump to next or
    *
    * PATCHING rules:
    * OR blocks should be patched to jump on then,
    * AND blocks should be patched to jump on another or block
    *
    * i have to have several lists:
    * list for address patching for AND block
    * list for address patching for OR block
    * list for address patching for THEN part
    *
    * now if i need nested if-else i have to put Stack of this lists
    * lists are added to stack with every new if
    *
    * */

    Stack<List<Integer>> StackOfANDblockPatchingAddresses = new Stack<>();
    Stack<List<Integer>> StackOfORblockPatchingAddresses = new Stack<>();
    Stack<List<Integer>> StackOfTHENblockPatchingAddresses = new Stack<>();

    Stack<Integer> StackOfForConditionAddresses = new Stack<>();

    Stack<List<Integer>> StackOfForStatementsStartPatchingAddresses = new Stack<>();

    Stack<Integer> StackOfForTailDesignatorAddresses = new Stack<>();

    Stack<List<Integer>> StackOfForExitLoopPatchingAddresses = new Stack<>();

    //i need to save and patch several address for for loop:
    //when if statement start, i have to make those list

    public void visit(IfStartDetected ifStartDetected){
        StackOfANDblockPatchingAddresses.push(new ArrayList<>());
        StackOfORblockPatchingAddresses.push(new ArrayList<>());
        StackOfTHENblockPatchingAddresses.push(new ArrayList<>());
    }

    //now process and condition parts
    public void visit(NormalCondFact normalCondFact){
        //This is single expression, it is on stack so i have to compare it to true to see
        //this could be also used in for loop, just to clarify how
        Code.loadConst(1);
        Code.putFalseJump(Code.eq,0);
        if(normalCondFact.getParent() instanceof PossibleCondFactYes){
            StackOfForExitLoopPatchingAddresses.peek().add(Code.pc-2);
        }else{
            StackOfANDblockPatchingAddresses.peek().add(Code.pc - 2);
        }
        //if it is not equal to 1, this will jump, in this AND blokc always place FalseJump


    }

    public void visit(RelopCondFact relopCondFact){
        //now i have to add jump because i have two vallues on expr stack to compare, i can check which is relop and generate code
        if(relopCondFact.getRelop() instanceof RelopLSSE){
            Code.putFalseJump(Code.le, 0);
        }else if(relopCondFact.getRelop() instanceof RelopEQUAL){
            Code.putFalseJump(Code.eq, 0);
        }else if(relopCondFact.getRelop() instanceof  RelopLSS){
            Code.putFalseJump(Code.lt, 0);
        }else if(relopCondFact.getRelop() instanceof  RelopGRT){
            Code.putFalseJump(Code.gt, 0);
        }else if(relopCondFact.getRelop() instanceof  RelopGRTE){
            Code.putFalseJump(Code.ge, 0);
        }else if(relopCondFact.getRelop() instanceof RelopNOTEQUAL){
            Code.putFalseJump(Code.ne, 0);
        }
        if(relopCondFact.getParent() instanceof PossibleCondFactYes){
            //resolve this, put address to jump outside of for loop or in the statements(this will be realised as unconditional jump
            StackOfForExitLoopPatchingAddresses.peek().add(Code.pc-2);
        }else{
            StackOfANDblockPatchingAddresses.peek().add(Code.pc -2);
        }
    }

    public void visit(PossibleCondFactNo possibleCondFactNo){
        //there is no need for any code here, because it will jump from StartOfTailDesignator
    }

    //now i have to process after all OR condition(end condition is separate), i have to patch all AND and make addresses to patch ORs

    public void visit(ORBlockDetected orBlockDetected){
        //if all AND blocks contained in this OR block are true, it should go to this unconfitional jump
        //i have to patch all previous AND blocks to jump after this unconditional jump
        Code.putJump(0);
        //also i have to put new OR block address for patch
        StackOfORblockPatchingAddresses.peek().add(Code.pc -2);

        for(int patchAdr: StackOfANDblockPatchingAddresses.peek()){
            Code.fixup(patchAdr);
        }


        StackOfANDblockPatchingAddresses.peek().clear();


    }

    //last OR Block End

    public void visit(IfConditionEndDetected ifConditionEndDetected){
        //this is last OR block, so i have to patch the rest of OR blocks to jump there because this is also begin of then part
        //BEGINING OF THEN BLOCK

        for(int patchAdr: StackOfORblockPatchingAddresses.peek()){
            Code.fixup(patchAdr);
        }

        StackOfORblockPatchingAddresses.peek().clear();
    }

    //now i have to patch all remaining AND addreses from last OR block, just in case some of them is false

    public void visit(IfBlock ifBlock){
        //all if block is processed(including than branch)
        //i have to place jump in case there is ELSE
        if(ifBlock.getParent() instanceof IfElseStatement){
            Code.putJump(0);
            StackOfTHENblockPatchingAddresses.peek().add(Code.pc -2);
        }

        //i have to patch all AND block addresses from last OR Block
        //all AND blocks should go to next OR blocks, but last AND block if it is false it has to go to ELSE or end
        for(int patchAdr: StackOfANDblockPatchingAddresses.peek()){
            Code.fixup(patchAdr);
        }

        StackOfANDblockPatchingAddresses.peek().clear();
    }


    public  void visit(IfElseStatement ifElseStatement){
        //i have to patch all then addreses
        for(int patchAdr: StackOfTHENblockPatchingAddresses.peek()){
            Code.fixup(patchAdr);
        }

        StackOfTHENblockPatchingAddresses.peek().clear();

        //also delete all lists
        StackOfANDblockPatchingAddresses.pop();
        StackOfORblockPatchingAddresses.pop();
        StackOfTHENblockPatchingAddresses.pop();
    }

    public void visit(IfStatement ifStatement){
        //clear all lists
        StackOfANDblockPatchingAddresses.pop();
        StackOfORblockPatchingAddresses.pop();
        StackOfTHENblockPatchingAddresses.pop();
    }

    public void visit(ForLoopStart forLoopStart){
        //i have to put new structures on stack
        StackOfForStatementsStartPatchingAddresses.push(new ArrayList<>());
        StackOfForExitLoopPatchingAddresses.push(new ArrayList<>());
    }

    public void visit(ForConditionStart forConditionStart){
        //i have to jump to this part of code after tail designator
        StackOfForConditionAddresses.push(Code.pc);
    }

    public void visit(ForStatementsStart forStatementsStart){
        //odavde skacem na proveru uslova
        Code.putJump(StackOfForConditionAddresses.peek());

        for(int patchAdr: StackOfForStatementsStartPatchingAddresses.peek()){
            Code.fixup(patchAdr);
        }
        StackOfForStatementsStartPatchingAddresses.peek().clear();
    }

    public void visit(ForStatement forStatement){
        //jump to tail designator after it is processed
        Code.putJump(StackOfForTailDesignatorAddresses.peek());
        //after this is out of for loop
        for(int patchAdr: StackOfForExitLoopPatchingAddresses.peek()){
            Code.fixup(patchAdr);
        }
        StackOfForExitLoopPatchingAddresses.peek().clear();
    }

    public void visit(ForTailDesignatorStart forTailDesignatorStart){//this is also condition end
        //resolve all tail designator addreses that are in need for patching
        //ovde propadnem ako je uslov dobar, znaci odmah treba da skocim na statements start
        Code.putJump(0);
        StackOfForStatementsStartPatchingAddresses.peek().add(Code.pc-2);

        StackOfForTailDesignatorAddresses.push(Code.pc);
    }

    public void visit(StatementForLoop statementForLoop){
        StackOfForTailDesignatorAddresses.pop();
        StackOfForConditionAddresses.pop();
        StackOfForStatementsStartPatchingAddresses.pop();
        StackOfForExitLoopPatchingAddresses.pop();
    }

    public void visit(StatementContinue statementContinue){
        Code.putJump(StackOfForTailDesignatorAddresses.peek());
    }

    public void visit(StatementBreak statementBreak){
        Code.putJump(0);
        StackOfForExitLoopPatchingAddresses.peek().add(Code.pc-2);
    }

    //multiple assignment processing:
    List<Obj> designators = new ArrayList<>();

    public void visit(DesignatorStatementMultipleAssign designatorStatementMultipleAssign){
        //first load array address
        Obj arr = designatorStatementMultipleAssign.getDesignator1().obj;
        Code.load(arr);
        Code.put(Code.arraylength);
        Code.loadConst(designators.size()+1);//+1 for the last designator
        Code.putFalseJump(Code.lt,0);
        int adr = Code.pc-2;
        Code.loadConst(1);
        Code.put(Code.trap);
        Code.fixup(adr);
        //here i can put code for array paste
        int i;
        for(i = designators.size()-1; i!=-1 ; i--){
            if(designators.get(i)==TabDerived.noObj){
                continue;
            }
            Code.load(arr);
            Code.loadConst(i);
            Code.put(Code.aload);
            Code.store(designators.get(i));
        }
        //in the end, copy the remaining elements to last designator
        Obj arr2 = designatorStatementMultipleAssign.getDesignator().obj;
        //i addded 0 to my iterator
        Code.loadConst(0);
        Code.put(Code.putstatic);
        Code.put2(0);
        //uzimanje iteratora i provera da li je dosao do kraja
        int adrCheck = Code.pc;
        Code.put(Code.getstatic);
        Code.put2(0);
        Code.load(arr2);
        Code.put(Code.arraylength);
        Code.putFalseJump(Code.lt, 0);
        adr = Code.pc-2;
        //ucitavanje elemnta desnog niza i upisivanje u levi niz
        Code.load(arr2);
        Code.put(Code.getstatic);
        Code.put2(0);
        Code.load(arr);
        Code.loadConst(designators.size());
        Code.put(Code.getstatic);
        Code.put2(0);
        Code.put(Code.add);
        Code.put(Code.aload);
        Code.put(Code.astore);
        Code.put(Code.getstatic);
        Code.put2(0);
        Code.loadConst(1);
        Code.put(Code.add);
        Code.put(Code.putstatic);
        Code.put2(0);
        Code.putJump(adrCheck);
        Code.fixup(adr);
        designators.clear();
    }

    public void visit(DesignatorYes designatorYes){
        //i can add those designators to a list, and whole processing to do in main Production for this
        //ovde bi trebalo da zapamtim gde storujem vrednosti jer ce se ovde procitati na expr-stacku
        designators.add(designatorYes.getDesignator().obj);
    }

    public void visit(DesignatorNo designatorNo){
        designators.add(TabDerived.noObj);
    }


}
