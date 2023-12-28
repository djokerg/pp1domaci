// generated with ast extension for cup
// version 0.8
// 28/11/2023 10:18:41


package rs.ac.bg.etf.pp1.ast;

public class TypeDerived1 extends Type {

    private OptionalNamespace optionalNamespace;

    public TypeDerived1 (OptionalNamespace optionalNamespace) {
        this.optionalNamespace=optionalNamespace;
        if(optionalNamespace!=null) optionalNamespace.setParent(this);
    }

    public OptionalNamespace getOptionalNamespace() {
        return optionalNamespace;
    }

    public void setOptionalNamespace(OptionalNamespace optionalNamespace) {
        this.optionalNamespace=optionalNamespace;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(optionalNamespace!=null) optionalNamespace.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(optionalNamespace!=null) optionalNamespace.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(optionalNamespace!=null) optionalNamespace.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("TypeDerived1(\n");

        if(optionalNamespace!=null)
            buffer.append(optionalNamespace.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [TypeDerived1]");
        return buffer.toString();
    }
}
