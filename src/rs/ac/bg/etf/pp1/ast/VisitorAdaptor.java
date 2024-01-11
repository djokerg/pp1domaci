// generated with ast extension for cup
// version 0.8
// 11/0/2024 10:52:27


package rs.ac.bg.etf.pp1.ast;

public abstract class VisitorAdaptor implements Visitor { 

    public void visit(DeclarationList DeclarationList) { }
    public void visit(PossibleFormPars PossibleFormPars) { }
    public void visit(Mulop Mulop) { }
    public void visit(Literal Literal) { }
    public void visit(PossibleArrayDecl PossibleArrayDecl) { }
    public void visit(Relop Relop) { }
    public void visit(SingleVar SingleVar) { }
    public void visit(PossibleDesignatorStatementList PossibleDesignatorStatementList) { }
    public void visit(StaticInitializerList StaticInitializerList) { }
    public void visit(OptionalExtends OptionalExtends) { }
    public void visit(StatementList StatementList) { }
    public void visit(NamespaceList NamespaceList) { }
    public void visit(Addop Addop) { }
    public void visit(Factor Factor) { }
    public void visit(CondTerm CondTerm) { }
    public void visit(PossibleDesignator PossibleDesignator) { }
    public void visit(StaticInitializerHelper StaticInitializerHelper) { }
    public void visit(Designator Designator) { }
    public void visit(Term Term) { }
    public void visit(StaticVarDeclList StaticVarDeclList) { }
    public void visit(Condition Condition) { }
    public void visit(DesStmtHelper DesStmtHelper) { }
    public void visit(MultipleVarDecl MultipleVarDecl) { }
    public void visit(DesignatorStatementList DesignatorStatementList) { }
    public void visit(IfConditionEndDetected IfConditionEndDetected) { }
    public void visit(OtpionalMethodDeclList OtpionalMethodDeclList) { }
    public void visit(VarDeclList VarDeclList) { }
    public void visit(Expr Expr) { }
    public void visit(ActPars ActPars) { }
    public void visit(FactorCallPossiblePars FactorCallPossiblePars) { }
    public void visit(MethodTypeName MethodTypeName) { }
    public void visit(DesignatorStatement DesignatorStatement) { }
    public void visit(MultipleConstDecl MultipleConstDecl) { }
    public void visit(LastFormParam LastFormParam) { }
    public void visit(Statement Statement) { }
    public void visit(Type Type) { }
    public void visit(CondFact CondFact) { }
    public void visit(MethodDeclList MethodDeclList) { }
    public void visit(LastSingleVar LastSingleVar) { }
    public void visit(FormParam FormParam) { }
    public void visit(FormPars FormPars) { }
    public void visit(PossibleCondFact PossibleCondFact) { }
    public void visit(MulopMOD MulopMOD) { visit(); }
    public void visit(MulopDIV MulopDIV) { visit(); }
    public void visit(MulopMUL MulopMUL) { visit(); }
    public void visit(AddopMINUS AddopMINUS) { visit(); }
    public void visit(AddopPLUS AddopPLUS) { visit(); }
    public void visit(RelopLSSE RelopLSSE) { visit(); }
    public void visit(RelopLSS RelopLSS) { visit(); }
    public void visit(RelopGRTE RelopGRTE) { visit(); }
    public void visit(RelopGRT RelopGRT) { visit(); }
    public void visit(RelopNOTEQUAL RelopNOTEQUAL) { visit(); }
    public void visit(RelopEQUAL RelopEQUAL) { visit(); }
    public void visit(Assignop Assignop) { visit(); }
    public void visit(Label Label) { visit(); }
    public void visit(DesignatorArrayName DesignatorArrayName) { visit(); }
    public void visit(DesignatorArray DesignatorArray) { visit(); }
    public void visit(DesignatorField DesignatorField) { visit(); }
    public void visit(DesignatorWONamespace DesignatorWONamespace) { visit(); }
    public void visit(DesignatorWNamespace DesignatorWNamespace) { visit(); }
    public void visit(FactorCallPossibleParsNo FactorCallPossibleParsNo) { visit(); }
    public void visit(FactorCallPossibleParsYes FactorCallPossibleParsYes) { visit(); }
    public void visit(FactorParenExpr FactorParenExpr) { visit(); }
    public void visit(FactorNewFunctionNoParams FactorNewFunctionNoParams) { visit(); }
    public void visit(FactorNewFunctionParams FactorNewFunctionParams) { visit(); }
    public void visit(FactorNewArrayExpr FactorNewArrayExpr) { visit(); }
    public void visit(FactorBool FactorBool) { visit(); }
    public void visit(FactorChar FactorChar) { visit(); }
    public void visit(FactorNum FactorNum) { visit(); }
    public void visit(FactorCall FactorCall) { visit(); }
    public void visit(FactorDesignator FactorDesignator) { visit(); }
    public void visit(TermFactor TermFactor) { visit(); }
    public void visit(TermMulop TermMulop) { visit(); }
    public void visit(ExprTerm ExprTerm) { visit(); }
    public void visit(ExprMinusTerm ExprMinusTerm) { visit(); }
    public void visit(GeneralExpr GeneralExpr) { visit(); }
    public void visit(RelopCondFact RelopCondFact) { visit(); }
    public void visit(NormalCondFact NormalCondFact) { visit(); }
    public void visit(NormalCondTerm NormalCondTerm) { visit(); }
    public void visit(CondTermBITAND CondTermBITAND) { visit(); }
    public void visit(ORBlockDetected ORBlockDetected) { visit(); }
    public void visit(NormalCondition NormalCondition) { visit(); }
    public void visit(ConditionBITOR ConditionBITOR) { visit(); }
    public void visit(ActParam ActParam) { visit(); }
    public void visit(ActParams ActParams) { visit(); }
    public void visit(DesignatorNo DesignatorNo) { visit(); }
    public void visit(DesignatorYes DesignatorYes) { visit(); }
    public void visit(DesStmtHelperNo DesStmtHelperNo) { visit(); }
    public void visit(DesStmtHelperYes DesStmtHelperYes) { visit(); }
    public void visit(DesignatorStatementMultipleAssign DesignatorStatementMultipleAssign) { visit(); }
    public void visit(DesignatorStmtMinusMinus DesignatorStmtMinusMinus) { visit(); }
    public void visit(DesignatorStmtPlusPlus DesignatorStmtPlusPlus) { visit(); }
    public void visit(DesignatorStmtCallArg DesignatorStmtCallArg) { visit(); }
    public void visit(DesignatorStmtCallNoArg DesignatorStmtCallNoArg) { visit(); }
    public void visit(DesignatorStatementError DesignatorStatementError) { visit(); }
    public void visit(DesignatorStmtAssign DesignatorStmtAssign) { visit(); }
    public void visit(PossibleDesignatorStatementListNo PossibleDesignatorStatementListNo) { visit(); }
    public void visit(PossibleDesignatorStatementListYes PossibleDesignatorStatementListYes) { visit(); }
    public void visit(SingleDesignatorStatement SingleDesignatorStatement) { visit(); }
    public void visit(DesignatorStatements DesignatorStatements) { visit(); }
    public void visit(PossibleCondFactNo PossibleCondFactNo) { visit(); }
    public void visit(PossibleCondFactYes PossibleCondFactYes) { visit(); }
    public void visit(ForTailDesignatorStart ForTailDesignatorStart) { visit(); }
    public void visit(ForStatement ForStatement) { visit(); }
    public void visit(ForStatementsStart ForStatementsStart) { visit(); }
    public void visit(ForConditionStart ForConditionStart) { visit(); }
    public void visit(ForLoopStart ForLoopStart) { visit(); }
    public void visit(StatementListDetected StatementListDetected) { visit(); }
    public void visit(IfBlock IfBlock) { visit(); }
    public void visit(IfConditionError IfConditionError) { visit(); }
    public void visit(IfConditionEndDetectedCorrect IfConditionEndDetectedCorrect) { visit(); }
    public void visit(IfStartDetected IfStartDetected) { visit(); }
    public void visit(StatementStmtList StatementStmtList) { visit(); }
    public void visit(StatementForLoop StatementForLoop) { visit(); }
    public void visit(StatementPrintMultiple StatementPrintMultiple) { visit(); }
    public void visit(StatementPrintSingle StatementPrintSingle) { visit(); }
    public void visit(StatementRead StatementRead) { visit(); }
    public void visit(StatementReturnExpr StatementReturnExpr) { visit(); }
    public void visit(StatementRetrun StatementRetrun) { visit(); }
    public void visit(StatementContinue StatementContinue) { visit(); }
    public void visit(StatementBreak StatementBreak) { visit(); }
    public void visit(IfElseStatement IfElseStatement) { visit(); }
    public void visit(IfStatement IfStatement) { visit(); }
    public void visit(StatementWDesignatorStmt StatementWDesignatorStmt) { visit(); }
    public void visit(NoStatement NoStatement) { visit(); }
    public void visit(Statements Statements) { visit(); }
    public void visit(LiteralCHAR LiteralCHAR) { visit(); }
    public void visit(LiteralBOOL LiteralBOOL) { visit(); }
    public void visit(LiteralNUM LiteralNUM) { visit(); }
    public void visit(NoMultipleConst NoMultipleConst) { visit(); }
    public void visit(MultipleConstDecls MultipleConstDecls) { visit(); }
    public void visit(ConstDecl ConstDecl) { visit(); }
    public void visit(NormalType NormalType) { visit(); }
    public void visit(TypeWNamespace TypeWNamespace) { visit(); }
    public void visit(SingleVarError SingleVarError) { visit(); }
    public void visit(SingleVarCorrect SingleVarCorrect) { visit(); }
    public void visit(LastSingleVarError LastSingleVarError) { visit(); }
    public void visit(LastSingleVarCorrect LastSingleVarCorrect) { visit(); }
    public void visit(MultipleVarDeclSingleVar MultipleVarDeclSingleVar) { visit(); }
    public void visit(MultipleVarDecls MultipleVarDecls) { visit(); }
    public void visit(VarDecl VarDecl) { visit(); }
    public void visit(NoVarDecl NoVarDecl) { visit(); }
    public void visit(VarDecls VarDecls) { visit(); }
    public void visit(NoDeclarationList NoDeclarationList) { visit(); }
    public void visit(DeclarationListClassDecl DeclarationListClassDecl) { visit(); }
    public void visit(DeclarationListConstDecl DeclarationListConstDecl) { visit(); }
    public void visit(DeclarationListVarDecl DeclarationListVarDecl) { visit(); }
    public void visit(NoPossibleArrayDecl NoPossibleArrayDecl) { visit(); }
    public void visit(PossibleArrayDeclYes PossibleArrayDeclYes) { visit(); }
    public void visit(FormParamError FormParamError) { visit(); }
    public void visit(FormParamCorrect FormParamCorrect) { visit(); }
    public void visit(LastFormParamError LastFormParamError) { visit(); }
    public void visit(LastFormParamCorrect LastFormParamCorrect) { visit(); }
    public void visit(SignleFromParam SignleFromParam) { visit(); }
    public void visit(FormParsList FormParsList) { visit(); }
    public void visit(NoPossibleFormPars NoPossibleFormPars) { visit(); }
    public void visit(PossibleFormParsDeclared PossibleFormParsDeclared) { visit(); }
    public void visit(VoidMethod VoidMethod) { visit(); }
    public void visit(MethodWithType MethodWithType) { visit(); }
    public void visit(MethodDecl MethodDecl) { visit(); }
    public void visit(NoMethodDecl NoMethodDecl) { visit(); }
    public void visit(MethodDecls MethodDecls) { visit(); }
    public void visit(NoOptionalMethodDecl NoOptionalMethodDecl) { visit(); }
    public void visit(OptionalMethodDecls OptionalMethodDecls) { visit(); }
    public void visit(StaticInitializer StaticInitializer) { visit(); }
    public void visit(StaticInitializerSingle StaticInitializerSingle) { visit(); }
    public void visit(StaticInitializers StaticInitializers) { visit(); }
    public void visit(StaticInitializerHelperNo StaticInitializerHelperNo) { visit(); }
    public void visit(StaticInitializerHelperYes StaticInitializerHelperYes) { visit(); }
    public void visit(NoStaticVarDecl NoStaticVarDecl) { visit(); }
    public void visit(StaticVarDecls StaticVarDecls) { visit(); }
    public void visit(NoExtends NoExtends) { visit(); }
    public void visit(Extends Extends) { visit(); }
    public void visit(ClassDecl ClassDecl) { visit(); }
    public void visit(NamespaceName NamespaceName) { visit(); }
    public void visit(Namespace Namespace) { visit(); }
    public void visit(NoNamespace NoNamespace) { visit(); }
    public void visit(Namespaces Namespaces) { visit(); }
    public void visit(ProgName ProgName) { visit(); }
    public void visit(Program Program) { visit(); }


    public void visit() { }
}
