// generated with ast extension for cup
// version 0.8
// 11/0/2024 10:52:27


package rs.ac.bg.etf.pp1.ast;

public class SingleVarCorrect extends SingleVar {

    private String varName;
    private PossibleArrayDecl PossibleArrayDecl;

    public SingleVarCorrect (String varName, PossibleArrayDecl PossibleArrayDecl) {
        this.varName=varName;
        this.PossibleArrayDecl=PossibleArrayDecl;
        if(PossibleArrayDecl!=null) PossibleArrayDecl.setParent(this);
    }

    public String getVarName() {
        return varName;
    }

    public void setVarName(String varName) {
        this.varName=varName;
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
        if(PossibleArrayDecl!=null) PossibleArrayDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(PossibleArrayDecl!=null) PossibleArrayDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(PossibleArrayDecl!=null) PossibleArrayDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("SingleVarCorrect(\n");

        buffer.append(" "+tab+varName);
        buffer.append("\n");

        if(PossibleArrayDecl!=null)
            buffer.append(PossibleArrayDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [SingleVarCorrect]");
        return buffer.toString();
    }
}
