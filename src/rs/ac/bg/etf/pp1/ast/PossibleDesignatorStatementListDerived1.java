// generated with ast extension for cup
// version 0.8
// 28/11/2023 23:51:7


package rs.ac.bg.etf.pp1.ast;

public class PossibleDesignatorStatementListDerived1 extends PossibleDesignatorStatementList {

    private DesignatorStatement DesignatorStatement;
    private ForLoopHelper ForLoopHelper;

    public PossibleDesignatorStatementListDerived1 (DesignatorStatement DesignatorStatement, ForLoopHelper ForLoopHelper) {
        this.DesignatorStatement=DesignatorStatement;
        if(DesignatorStatement!=null) DesignatorStatement.setParent(this);
        this.ForLoopHelper=ForLoopHelper;
        if(ForLoopHelper!=null) ForLoopHelper.setParent(this);
    }

    public DesignatorStatement getDesignatorStatement() {
        return DesignatorStatement;
    }

    public void setDesignatorStatement(DesignatorStatement DesignatorStatement) {
        this.DesignatorStatement=DesignatorStatement;
    }

    public ForLoopHelper getForLoopHelper() {
        return ForLoopHelper;
    }

    public void setForLoopHelper(ForLoopHelper ForLoopHelper) {
        this.ForLoopHelper=ForLoopHelper;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DesignatorStatement!=null) DesignatorStatement.accept(visitor);
        if(ForLoopHelper!=null) ForLoopHelper.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorStatement!=null) DesignatorStatement.traverseTopDown(visitor);
        if(ForLoopHelper!=null) ForLoopHelper.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorStatement!=null) DesignatorStatement.traverseBottomUp(visitor);
        if(ForLoopHelper!=null) ForLoopHelper.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("PossibleDesignatorStatementListDerived1(\n");

        if(DesignatorStatement!=null)
            buffer.append(DesignatorStatement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ForLoopHelper!=null)
            buffer.append(ForLoopHelper.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [PossibleDesignatorStatementListDerived1]");
        return buffer.toString();
    }
}
