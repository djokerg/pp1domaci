// generated with ast extension for cup
// version 0.8
// 9/0/2024 16:42:47


package rs.ac.bg.etf.pp1.ast;

public class PossibleDesignatorStatements extends PossibleDesignatorStatementList {

    private PossibleDesignatorStatementList PossibleDesignatorStatementList;
    private DesignatorStatement DesignatorStatement;

    public PossibleDesignatorStatements (PossibleDesignatorStatementList PossibleDesignatorStatementList, DesignatorStatement DesignatorStatement) {
        this.PossibleDesignatorStatementList=PossibleDesignatorStatementList;
        if(PossibleDesignatorStatementList!=null) PossibleDesignatorStatementList.setParent(this);
        this.DesignatorStatement=DesignatorStatement;
        if(DesignatorStatement!=null) DesignatorStatement.setParent(this);
    }

    public PossibleDesignatorStatementList getPossibleDesignatorStatementList() {
        return PossibleDesignatorStatementList;
    }

    public void setPossibleDesignatorStatementList(PossibleDesignatorStatementList PossibleDesignatorStatementList) {
        this.PossibleDesignatorStatementList=PossibleDesignatorStatementList;
    }

    public DesignatorStatement getDesignatorStatement() {
        return DesignatorStatement;
    }

    public void setDesignatorStatement(DesignatorStatement DesignatorStatement) {
        this.DesignatorStatement=DesignatorStatement;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(PossibleDesignatorStatementList!=null) PossibleDesignatorStatementList.accept(visitor);
        if(DesignatorStatement!=null) DesignatorStatement.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(PossibleDesignatorStatementList!=null) PossibleDesignatorStatementList.traverseTopDown(visitor);
        if(DesignatorStatement!=null) DesignatorStatement.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(PossibleDesignatorStatementList!=null) PossibleDesignatorStatementList.traverseBottomUp(visitor);
        if(DesignatorStatement!=null) DesignatorStatement.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("PossibleDesignatorStatements(\n");

        if(PossibleDesignatorStatementList!=null)
            buffer.append(PossibleDesignatorStatementList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(DesignatorStatement!=null)
            buffer.append(DesignatorStatement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [PossibleDesignatorStatements]");
        return buffer.toString();
    }
}
