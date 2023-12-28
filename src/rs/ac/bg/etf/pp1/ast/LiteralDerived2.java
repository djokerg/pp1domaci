// generated with ast extension for cup
// version 0.8
// 28/11/2023 17:33:55


package rs.ac.bg.etf.pp1.ast;

public class LiteralDerived2 extends Literal {

    public LiteralDerived2 () {
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
        buffer.append("LiteralDerived2(\n");

        buffer.append(tab);
        buffer.append(") [LiteralDerived2]");
        return buffer.toString();
    }
}
