// generated with ast extension for cup
// version 0.8
// 28/11/2023 23:51:7


package rs.ac.bg.etf.pp1.ast;

public class DesStmtHelperDerived2 extends DesStmtHelper {

    private DesStmtHelper DesStmtHelper;
    private Designator Designator;

    public DesStmtHelperDerived2 (DesStmtHelper DesStmtHelper, Designator Designator) {
        this.DesStmtHelper=DesStmtHelper;
        if(DesStmtHelper!=null) DesStmtHelper.setParent(this);
        this.Designator=Designator;
        if(Designator!=null) Designator.setParent(this);
    }

    public DesStmtHelper getDesStmtHelper() {
        return DesStmtHelper;
    }

    public void setDesStmtHelper(DesStmtHelper DesStmtHelper) {
        this.DesStmtHelper=DesStmtHelper;
    }

    public Designator getDesignator() {
        return Designator;
    }

    public void setDesignator(Designator Designator) {
        this.Designator=Designator;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DesStmtHelper!=null) DesStmtHelper.accept(visitor);
        if(Designator!=null) Designator.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesStmtHelper!=null) DesStmtHelper.traverseTopDown(visitor);
        if(Designator!=null) Designator.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesStmtHelper!=null) DesStmtHelper.traverseBottomUp(visitor);
        if(Designator!=null) Designator.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesStmtHelperDerived2(\n");

        if(DesStmtHelper!=null)
            buffer.append(DesStmtHelper.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Designator!=null)
            buffer.append(Designator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesStmtHelperDerived2]");
        return buffer.toString();
    }
}
