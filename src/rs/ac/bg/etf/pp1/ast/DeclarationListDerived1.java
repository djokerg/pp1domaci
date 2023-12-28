// generated with ast extension for cup
// version 0.8
// 27/11/2023 18:25:22


package src.rs.ac.bg.etf.pp1.ast;

public class DeclarationListDerived1 extends DeclarationList {

    public DeclarationListDerived1 () {
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DeclarationListDerived1(\n");

        buffer.append(tab);
        buffer.append(") [DeclarationListDerived1]");
        return buffer.toString();
    }
}
