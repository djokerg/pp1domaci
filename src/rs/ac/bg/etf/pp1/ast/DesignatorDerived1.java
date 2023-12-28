// generated with ast extension for cup
// version 0.8
// 28/11/2023 17:33:55


package rs.ac.bg.etf.pp1.ast;

public class DesignatorDerived1 extends Designator {

    private DesignatorHelperList DesignatorHelperList;

    public DesignatorDerived1 (DesignatorHelperList DesignatorHelperList) {
        this.DesignatorHelperList=DesignatorHelperList;
        if(DesignatorHelperList!=null) DesignatorHelperList.setParent(this);
    }

    public DesignatorHelperList getDesignatorHelperList() {
        return DesignatorHelperList;
    }

    public void setDesignatorHelperList(DesignatorHelperList DesignatorHelperList) {
        this.DesignatorHelperList=DesignatorHelperList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DesignatorHelperList!=null) DesignatorHelperList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorHelperList!=null) DesignatorHelperList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorHelperList!=null) DesignatorHelperList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorDerived1(\n");

        if(DesignatorHelperList!=null)
            buffer.append(DesignatorHelperList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorDerived1]");
        return buffer.toString();
    }
}
