// generated with ast extension for cup
// version 0.8
// 28/11/2023 23:51:7


package rs.ac.bg.etf.pp1.ast;

public class ForLoopHelperDerived1 extends ForLoopHelper {

    private ForLoopHelper ForLoopHelper;
    private DesignatorStatement DesignatorStatement;

    public ForLoopHelperDerived1 (ForLoopHelper ForLoopHelper, DesignatorStatement DesignatorStatement) {
        this.ForLoopHelper=ForLoopHelper;
        if(ForLoopHelper!=null) ForLoopHelper.setParent(this);
        this.DesignatorStatement=DesignatorStatement;
        if(DesignatorStatement!=null) DesignatorStatement.setParent(this);
    }

    public ForLoopHelper getForLoopHelper() {
        return ForLoopHelper;
    }

    public void setForLoopHelper(ForLoopHelper ForLoopHelper) {
        this.ForLoopHelper=ForLoopHelper;
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
        if(ForLoopHelper!=null) ForLoopHelper.accept(visitor);
        if(DesignatorStatement!=null) DesignatorStatement.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ForLoopHelper!=null) ForLoopHelper.traverseTopDown(visitor);
        if(DesignatorStatement!=null) DesignatorStatement.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ForLoopHelper!=null) ForLoopHelper.traverseBottomUp(visitor);
        if(DesignatorStatement!=null) DesignatorStatement.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ForLoopHelperDerived1(\n");

        if(ForLoopHelper!=null)
            buffer.append(ForLoopHelper.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(DesignatorStatement!=null)
            buffer.append(DesignatorStatement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ForLoopHelperDerived1]");
        return buffer.toString();
    }
}
