// generated with ast extension for cup
// version 0.8
// 11/0/2024 10:52:27


package rs.ac.bg.etf.pp1.ast;

public class LastFormParamCorrect extends LastFormParam {

    private Type Type;
    private String paramName;
    private PossibleArrayDecl PossibleArrayDecl;

    public LastFormParamCorrect (Type Type, String paramName, PossibleArrayDecl PossibleArrayDecl) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.paramName=paramName;
        this.PossibleArrayDecl=PossibleArrayDecl;
        if(PossibleArrayDecl!=null) PossibleArrayDecl.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName=paramName;
    }

    public PossibleArrayDecl getPossibleArrayDecl() {
        return PossibleArrayDecl;
    }

    public void setPossibleArrayDecl(PossibleArrayDecl PossibleArrayDecl) {
        this.PossibleArrayDecl=PossibleArrayDecl;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Type!=null) Type.accept(visitor);
        if(PossibleArrayDecl!=null) PossibleArrayDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(PossibleArrayDecl!=null) PossibleArrayDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(PossibleArrayDecl!=null) PossibleArrayDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("LastFormParamCorrect(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(" "+tab+paramName);
        buffer.append("\n");

        if(PossibleArrayDecl!=null)
            buffer.append(PossibleArrayDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [LastFormParamCorrect]");
        return buffer.toString();
    }
}
