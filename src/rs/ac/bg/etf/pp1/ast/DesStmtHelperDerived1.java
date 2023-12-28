// generated with ast extension for cup
// version 0.8
// 28/11/2023 23:51:7


package rs.ac.bg.etf.pp1.ast;

public class DesStmtHelperDerived1 extends DesStmtHelper {

    private DesStmtHelper DesStmtHelper;

    public DesStmtHelperDerived1 (DesStmtHelper DesStmtHelper) {
        this.DesStmtHelper=DesStmtHelper;
        if(DesStmtHelper!=null) DesStmtHelper.setParent(this);
    }

    public DesStmtHelper getDesStmtHelper() {
        return DesStmtHelper;
    }

    public void setDesStmtHelper(DesStmtHelper DesStmtHelper) {
        this.DesStmtHelper=DesStmtHelper;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DesStmtHelper!=null) DesStmtHelper.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesStmtHelper!=null) DesStmtHelper.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesStmtHelper!=null) DesStmtHelper.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesStmtHelperDerived1(\n");

        if(DesStmtHelper!=null)
            buffer.append(DesStmtHelper.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesStmtHelperDerived1]");
        return buffer.toString();
    }
}
