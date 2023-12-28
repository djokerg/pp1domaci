// generated with ast extension for cup
// version 0.8
// 28/11/2023 23:51:7


package rs.ac.bg.etf.pp1.ast;

public class MultipleConstDeclDerived1 extends MultipleConstDecl {

    private MultipleConstDecl MultipleConstDecl;
    private Literal Literal;

    public MultipleConstDeclDerived1 (MultipleConstDecl MultipleConstDecl, Literal Literal) {
        this.MultipleConstDecl=MultipleConstDecl;
        if(MultipleConstDecl!=null) MultipleConstDecl.setParent(this);
        this.Literal=Literal;
        if(Literal!=null) Literal.setParent(this);
    }

    public MultipleConstDecl getMultipleConstDecl() {
        return MultipleConstDecl;
    }

    public void setMultipleConstDecl(MultipleConstDecl MultipleConstDecl) {
        this.MultipleConstDecl=MultipleConstDecl;
    }

    public Literal getLiteral() {
        return Literal;
    }

    public void setLiteral(Literal Literal) {
        this.Literal=Literal;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(MultipleConstDecl!=null) MultipleConstDecl.accept(visitor);
        if(Literal!=null) Literal.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MultipleConstDecl!=null) MultipleConstDecl.traverseTopDown(visitor);
        if(Literal!=null) Literal.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MultipleConstDecl!=null) MultipleConstDecl.traverseBottomUp(visitor);
        if(Literal!=null) Literal.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MultipleConstDeclDerived1(\n");

        if(MultipleConstDecl!=null)
            buffer.append(MultipleConstDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Literal!=null)
            buffer.append(Literal.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MultipleConstDeclDerived1]");
        return buffer.toString();
    }
}
