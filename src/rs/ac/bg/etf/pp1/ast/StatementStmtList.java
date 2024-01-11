// generated with ast extension for cup
// version 0.8
// 11/0/2024 15:2:59


package rs.ac.bg.etf.pp1.ast;

public class StatementStmtList extends Statement {

    private StatementListDetected StatementListDetected;
    private StatementList StatementList;

    public StatementStmtList (StatementListDetected StatementListDetected, StatementList StatementList) {
        this.StatementListDetected=StatementListDetected;
        if(StatementListDetected!=null) StatementListDetected.setParent(this);
        this.StatementList=StatementList;
        if(StatementList!=null) StatementList.setParent(this);
    }

    public StatementListDetected getStatementListDetected() {
        return StatementListDetected;
    }

    public void setStatementListDetected(StatementListDetected StatementListDetected) {
        this.StatementListDetected=StatementListDetected;
    }

    public StatementList getStatementList() {
        return StatementList;
    }

    public void setStatementList(StatementList StatementList) {
        this.StatementList=StatementList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(StatementListDetected!=null) StatementListDetected.accept(visitor);
        if(StatementList!=null) StatementList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(StatementListDetected!=null) StatementListDetected.traverseTopDown(visitor);
        if(StatementList!=null) StatementList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(StatementListDetected!=null) StatementListDetected.traverseBottomUp(visitor);
        if(StatementList!=null) StatementList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("StatementStmtList(\n");

        if(StatementListDetected!=null)
            buffer.append(StatementListDetected.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(StatementList!=null)
            buffer.append(StatementList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [StatementStmtList]");
        return buffer.toString();
    }
}
