// generated with ast extension for cup
// version 0.8
// 28/11/2023 17:33:55


package rs.ac.bg.etf.pp1.ast;

public class FactorDerived6 extends Factor {

    public FactorDerived6 () {
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
        buffer.append("FactorDerived6(\n");

        buffer.append(tab);
        buffer.append(") [FactorDerived6]");
        return buffer.toString();
    }
}
