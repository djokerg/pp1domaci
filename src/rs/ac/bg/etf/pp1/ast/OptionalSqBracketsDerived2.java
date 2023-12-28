// generated with ast extension for cup
// version 0.8
// 28/11/2023 10:18:41


package rs.ac.bg.etf.pp1.ast;

public class OptionalSqBracketsDerived2 extends OptionalSqBrackets {

    public OptionalSqBracketsDerived2 () {
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
        buffer.append("OptionalSqBracketsDerived2(\n");

        buffer.append(tab);
        buffer.append(") [OptionalSqBracketsDerived2]");
        return buffer.toString();
    }
}
