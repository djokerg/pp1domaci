// generated with ast extension for cup
// version 0.8
// 28/11/2023 10:18:41


package rs.ac.bg.etf.pp1.ast;

public class ArrayDeclListDerived1 extends ArrayDeclList {

    private ArrayDeclList arrayDeclList;
    private ArrayDecl arrayDecl;

    public ArrayDeclListDerived1 (ArrayDeclList arrayDeclList, ArrayDecl arrayDecl) {
        this.arrayDeclList=arrayDeclList;
        if(arrayDeclList!=null) arrayDeclList.setParent(this);
        this.arrayDecl=arrayDecl;
        if(arrayDecl!=null) arrayDecl.setParent(this);
    }

    public ArrayDeclList getArrayDeclList() {
        return arrayDeclList;
    }

    public void setArrayDeclList(ArrayDeclList arrayDeclList) {
        this.arrayDeclList=arrayDeclList;
    }

    public ArrayDecl getArrayDecl() {
        return arrayDecl;
    }

    public void setArrayDecl(ArrayDecl arrayDecl) {
        this.arrayDecl=arrayDecl;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(arrayDeclList!=null) arrayDeclList.accept(visitor);
        if(arrayDecl!=null) arrayDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(arrayDeclList!=null) arrayDeclList.traverseTopDown(visitor);
        if(arrayDecl!=null) arrayDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(arrayDeclList!=null) arrayDeclList.traverseBottomUp(visitor);
        if(arrayDecl!=null) arrayDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ArrayDeclListDerived1(\n");

        if(arrayDeclList!=null)
            buffer.append(arrayDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(arrayDecl!=null)
            buffer.append(arrayDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ArrayDeclListDerived1]");
        return buffer.toString();
    }
}
