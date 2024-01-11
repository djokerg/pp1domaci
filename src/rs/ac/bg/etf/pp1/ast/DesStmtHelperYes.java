// generated with ast extension for cup
// version 0.8
// 11/0/2024 10:52:27


package rs.ac.bg.etf.pp1.ast;

public class DesStmtHelperYes extends DesStmtHelper {

    private DesStmtHelper DesStmtHelper;
    private PossibleDesignator PossibleDesignator;

    public DesStmtHelperYes (DesStmtHelper DesStmtHelper, PossibleDesignator PossibleDesignator) {
        this.DesStmtHelper=DesStmtHelper;
        if(DesStmtHelper!=null) DesStmtHelper.setParent(this);
        this.PossibleDesignator=PossibleDesignator;
        if(PossibleDesignator!=null) PossibleDesignator.setParent(this);
    }

    public DesStmtHelper getDesStmtHelper() {
        return DesStmtHelper;
    }

    public void setDesStmtHelper(DesStmtHelper DesStmtHelper) {
        this.DesStmtHelper=DesStmtHelper;
    }

    public PossibleDesignator getPossibleDesignator() {
        return PossibleDesignator;
    }

    public void setPossibleDesignator(PossibleDesignator PossibleDesignator) {
        this.PossibleDesignator=PossibleDesignator;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DesStmtHelper!=null) DesStmtHelper.accept(visitor);
        if(PossibleDesignator!=null) PossibleDesignator.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesStmtHelper!=null) DesStmtHelper.traverseTopDown(visitor);
        if(PossibleDesignator!=null) PossibleDesignator.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesStmtHelper!=null) DesStmtHelper.traverseBottomUp(visitor);
        if(PossibleDesignator!=null) PossibleDesignator.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesStmtHelperYes(\n");

        if(DesStmtHelper!=null)
            buffer.append(DesStmtHelper.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(PossibleDesignator!=null)
            buffer.append(PossibleDesignator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesStmtHelperYes]");
        return buffer.toString();
    }
}
