// generated with ast extension for cup
// version 0.8
// 28/11/2023 23:51:7


package rs.ac.bg.etf.pp1.ast;

public class StatementDerived11 extends Statement {

    private PossibleDesignatorStatementList PossibleDesignatorStatementList;
    private PossibleCondFact PossibleCondFact;
    private PossibleDesignatorStatementList PossibleDesignatorStatementList1;
    private Statement Statement;

    public StatementDerived11 (PossibleDesignatorStatementList PossibleDesignatorStatementList, PossibleCondFact PossibleCondFact, PossibleDesignatorStatementList PossibleDesignatorStatementList1, Statement Statement) {
        this.PossibleDesignatorStatementList=PossibleDesignatorStatementList;
        if(PossibleDesignatorStatementList!=null) PossibleDesignatorStatementList.setParent(this);
        this.PossibleCondFact=PossibleCondFact;
        if(PossibleCondFact!=null) PossibleCondFact.setParent(this);
        this.PossibleDesignatorStatementList1=PossibleDesignatorStatementList1;
        if(PossibleDesignatorStatementList1!=null) PossibleDesignatorStatementList1.setParent(this);
        this.Statement=Statement;
        if(Statement!=null) Statement.setParent(this);
    }

    public PossibleDesignatorStatementList getPossibleDesignatorStatementList() {
        return PossibleDesignatorStatementList;
    }

    public void setPossibleDesignatorStatementList(PossibleDesignatorStatementList PossibleDesignatorStatementList) {
        this.PossibleDesignatorStatementList=PossibleDesignatorStatementList;
    }

    public PossibleCondFact getPossibleCondFact() {
        return PossibleCondFact;
    }

    public void setPossibleCondFact(PossibleCondFact PossibleCondFact) {
        this.PossibleCondFact=PossibleCondFact;
    }

    public PossibleDesignatorStatementList getPossibleDesignatorStatementList1() {
        return PossibleDesignatorStatementList1;
    }

    public void setPossibleDesignatorStatementList1(PossibleDesignatorStatementList PossibleDesignatorStatementList1) {
        this.PossibleDesignatorStatementList1=PossibleDesignatorStatementList1;
    }

    public Statement getStatement() {
        return Statement;
    }

    public void setStatement(Statement Statement) {
        this.Statement=Statement;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(PossibleDesignatorStatementList!=null) PossibleDesignatorStatementList.accept(visitor);
        if(PossibleCondFact!=null) PossibleCondFact.accept(visitor);
        if(PossibleDesignatorStatementList1!=null) PossibleDesignatorStatementList1.accept(visitor);
        if(Statement!=null) Statement.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(PossibleDesignatorStatementList!=null) PossibleDesignatorStatementList.traverseTopDown(visitor);
        if(PossibleCondFact!=null) PossibleCondFact.traverseTopDown(visitor);
        if(PossibleDesignatorStatementList1!=null) PossibleDesignatorStatementList1.traverseTopDown(visitor);
        if(Statement!=null) Statement.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(PossibleDesignatorStatementList!=null) PossibleDesignatorStatementList.traverseBottomUp(visitor);
        if(PossibleCondFact!=null) PossibleCondFact.traverseBottomUp(visitor);
        if(PossibleDesignatorStatementList1!=null) PossibleDesignatorStatementList1.traverseBottomUp(visitor);
        if(Statement!=null) Statement.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("StatementDerived11(\n");

        if(PossibleDesignatorStatementList!=null)
            buffer.append(PossibleDesignatorStatementList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(PossibleCondFact!=null)
            buffer.append(PossibleCondFact.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(PossibleDesignatorStatementList1!=null)
            buffer.append(PossibleDesignatorStatementList1.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Statement!=null)
            buffer.append(Statement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [StatementDerived11]");
        return buffer.toString();
    }
}
