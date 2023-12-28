// generated with ast extension for cup
// version 0.8
// 28/11/2023 11:45:23


package rs.ac.bg.etf.pp1.ast;

public class VarDeclDerived2 extends VarDecl {

    private Type Type;
    private ArrayDeclList arrayDeclList;

    public VarDeclDerived2 (Type Type, ArrayDeclList arrayDeclList) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.arrayDeclList=arrayDeclList;
        if(arrayDeclList!=null) arrayDeclList.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public ArrayDeclList getArrayDeclList() {
        return arrayDeclList;
    }

    public void setArrayDeclList(ArrayDeclList arrayDeclList) {
        this.arrayDeclList=arrayDeclList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Type!=null) Type.accept(visitor);
        if(arrayDeclList!=null) arrayDeclList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(arrayDeclList!=null) arrayDeclList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(arrayDeclList!=null) arrayDeclList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarDeclDerived2(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(arrayDeclList!=null)
            buffer.append(arrayDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarDeclDerived2]");
        return buffer.toString();
    }
}
