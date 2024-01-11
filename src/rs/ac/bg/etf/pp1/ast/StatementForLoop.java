// generated with ast extension for cup
// version 0.8
// 11/0/2024 10:52:27


package rs.ac.bg.etf.pp1.ast;

public class StatementForLoop extends Statement {

    private ForLoopStart ForLoopStart;
    private PossibleDesignatorStatementList PossibleDesignatorStatementList;
    private ForConditionStart ForConditionStart;
    private PossibleCondFact PossibleCondFact;
    private ForTailDesignatorStart ForTailDesignatorStart;
    private PossibleDesignatorStatementList PossibleDesignatorStatementList1;
    private ForStatementsStart ForStatementsStart;
    private ForStatement ForStatement;

    public StatementForLoop (ForLoopStart ForLoopStart, PossibleDesignatorStatementList PossibleDesignatorStatementList, ForConditionStart ForConditionStart, PossibleCondFact PossibleCondFact, ForTailDesignatorStart ForTailDesignatorStart, PossibleDesignatorStatementList PossibleDesignatorStatementList1, ForStatementsStart ForStatementsStart, ForStatement ForStatement) {
        this.ForLoopStart=ForLoopStart;
        if(ForLoopStart!=null) ForLoopStart.setParent(this);
        this.PossibleDesignatorStatementList=PossibleDesignatorStatementList;
        if(PossibleDesignatorStatementList!=null) PossibleDesignatorStatementList.setParent(this);
        this.ForConditionStart=ForConditionStart;
        if(ForConditionStart!=null) ForConditionStart.setParent(this);
        this.PossibleCondFact=PossibleCondFact;
        if(PossibleCondFact!=null) PossibleCondFact.setParent(this);
        this.ForTailDesignatorStart=ForTailDesignatorStart;
        if(ForTailDesignatorStart!=null) ForTailDesignatorStart.setParent(this);
        this.PossibleDesignatorStatementList1=PossibleDesignatorStatementList1;
        if(PossibleDesignatorStatementList1!=null) PossibleDesignatorStatementList1.setParent(this);
        this.ForStatementsStart=ForStatementsStart;
        if(ForStatementsStart!=null) ForStatementsStart.setParent(this);
        this.ForStatement=ForStatement;
        if(ForStatement!=null) ForStatement.setParent(this);
    }

    public ForLoopStart getForLoopStart() {
        return ForLoopStart;
    }

    public void setForLoopStart(ForLoopStart ForLoopStart) {
        this.ForLoopStart=ForLoopStart;
    }

    public PossibleDesignatorStatementList getPossibleDesignatorStatementList() {
        return PossibleDesignatorStatementList;
    }

    public void setPossibleDesignatorStatementList(PossibleDesignatorStatementList PossibleDesignatorStatementList) {
        this.PossibleDesignatorStatementList=PossibleDesignatorStatementList;
    }

    public ForConditionStart getForConditionStart() {
        return ForConditionStart;
    }

    public void setForConditionStart(ForConditionStart ForConditionStart) {
        this.ForConditionStart=ForConditionStart;
    }

    public PossibleCondFact getPossibleCondFact() {
        return PossibleCondFact;
    }

    public void setPossibleCondFact(PossibleCondFact PossibleCondFact) {
        this.PossibleCondFact=PossibleCondFact;
    }

    public ForTailDesignatorStart getForTailDesignatorStart() {
        return ForTailDesignatorStart;
    }

    public void setForTailDesignatorStart(ForTailDesignatorStart ForTailDesignatorStart) {
        this.ForTailDesignatorStart=ForTailDesignatorStart;
    }

    public PossibleDesignatorStatementList getPossibleDesignatorStatementList1() {
        return PossibleDesignatorStatementList1;
    }

    public void setPossibleDesignatorStatementList1(PossibleDesignatorStatementList PossibleDesignatorStatementList1) {
        this.PossibleDesignatorStatementList1=PossibleDesignatorStatementList1;
    }

    public ForStatementsStart getForStatementsStart() {
        return ForStatementsStart;
    }

    public void setForStatementsStart(ForStatementsStart ForStatementsStart) {
        this.ForStatementsStart=ForStatementsStart;
    }

    public ForStatement getForStatement() {
        return ForStatement;
    }

    public void setForStatement(ForStatement ForStatement) {
        this.ForStatement=ForStatement;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ForLoopStart!=null) ForLoopStart.accept(visitor);
        if(PossibleDesignatorStatementList!=null) PossibleDesignatorStatementList.accept(visitor);
        if(ForConditionStart!=null) ForConditionStart.accept(visitor);
        if(PossibleCondFact!=null) PossibleCondFact.accept(visitor);
        if(ForTailDesignatorStart!=null) ForTailDesignatorStart.accept(visitor);
        if(PossibleDesignatorStatementList1!=null) PossibleDesignatorStatementList1.accept(visitor);
        if(ForStatementsStart!=null) ForStatementsStart.accept(visitor);
        if(ForStatement!=null) ForStatement.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ForLoopStart!=null) ForLoopStart.traverseTopDown(visitor);
        if(PossibleDesignatorStatementList!=null) PossibleDesignatorStatementList.traverseTopDown(visitor);
        if(ForConditionStart!=null) ForConditionStart.traverseTopDown(visitor);
        if(PossibleCondFact!=null) PossibleCondFact.traverseTopDown(visitor);
        if(ForTailDesignatorStart!=null) ForTailDesignatorStart.traverseTopDown(visitor);
        if(PossibleDesignatorStatementList1!=null) PossibleDesignatorStatementList1.traverseTopDown(visitor);
        if(ForStatementsStart!=null) ForStatementsStart.traverseTopDown(visitor);
        if(ForStatement!=null) ForStatement.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ForLoopStart!=null) ForLoopStart.traverseBottomUp(visitor);
        if(PossibleDesignatorStatementList!=null) PossibleDesignatorStatementList.traverseBottomUp(visitor);
        if(ForConditionStart!=null) ForConditionStart.traverseBottomUp(visitor);
        if(PossibleCondFact!=null) PossibleCondFact.traverseBottomUp(visitor);
        if(ForTailDesignatorStart!=null) ForTailDesignatorStart.traverseBottomUp(visitor);
        if(PossibleDesignatorStatementList1!=null) PossibleDesignatorStatementList1.traverseBottomUp(visitor);
        if(ForStatementsStart!=null) ForStatementsStart.traverseBottomUp(visitor);
        if(ForStatement!=null) ForStatement.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("StatementForLoop(\n");

        if(ForLoopStart!=null)
            buffer.append(ForLoopStart.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(PossibleDesignatorStatementList!=null)
            buffer.append(PossibleDesignatorStatementList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ForConditionStart!=null)
            buffer.append(ForConditionStart.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(PossibleCondFact!=null)
            buffer.append(PossibleCondFact.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ForTailDesignatorStart!=null)
            buffer.append(ForTailDesignatorStart.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(PossibleDesignatorStatementList1!=null)
            buffer.append(PossibleDesignatorStatementList1.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ForStatementsStart!=null)
            buffer.append(ForStatementsStart.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ForStatement!=null)
            buffer.append(ForStatement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [StatementForLoop]");
        return buffer.toString();
    }
}
