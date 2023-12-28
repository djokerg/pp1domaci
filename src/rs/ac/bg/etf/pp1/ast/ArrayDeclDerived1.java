// generated with ast extension for cup
// version 0.8
// 28/11/2023 10:18:41


package rs.ac.bg.etf.pp1.ast;

public class ArrayDeclDerived1 extends ArrayDecl {

    private OptionalSqBrackets optionalSqBrackets;

    public ArrayDeclDerived1 (OptionalSqBrackets optionalSqBrackets) {
        this.optionalSqBrackets=optionalSqBrackets;
        if(optionalSqBrackets!=null) optionalSqBrackets.setParent(this);
    }

    public OptionalSqBrackets getOptionalSqBrackets() {
        return optionalSqBrackets;
    }

    public void setOptionalSqBrackets(OptionalSqBrackets optionalSqBrackets) {
        this.optionalSqBrackets=optionalSqBrackets;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(optionalSqBrackets!=null) optionalSqBrackets.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(optionalSqBrackets!=null) optionalSqBrackets.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(optionalSqBrackets!=null) optionalSqBrackets.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ArrayDeclDerived1(\n");

        if(optionalSqBrackets!=null)
            buffer.append(optionalSqBrackets.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ArrayDeclDerived1]");
        return buffer.toString();
    }
}
