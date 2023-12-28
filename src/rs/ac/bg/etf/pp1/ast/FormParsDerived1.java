// generated with ast extension for cup
// version 0.8
// 28/11/2023 17:33:55


package rs.ac.bg.etf.pp1.ast;

public class FormParsDerived1 extends FormPars {

    private FormPars FormPars;
    private Type Type;
    private PossibleArrayDecl PossibleArrayDecl;

    public FormParsDerived1 (FormPars FormPars, Type Type, PossibleArrayDecl PossibleArrayDecl) {
        this.FormPars=FormPars;
        if(FormPars!=null) FormPars.setParent(this);
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.PossibleArrayDecl=PossibleArrayDecl;
        if(PossibleArrayDecl!=null) PossibleArrayDecl.setParent(this);
    }

    public FormPars getFormPars() {
        return FormPars;
    }

    public void setFormPars(FormPars FormPars) {
        this.FormPars=FormPars;
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
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
        if(FormPars!=null) FormPars.accept(visitor);
        if(Type!=null) Type.accept(visitor);
        if(PossibleArrayDecl!=null) PossibleArrayDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(FormPars!=null) FormPars.traverseTopDown(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(PossibleArrayDecl!=null) PossibleArrayDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(FormPars!=null) FormPars.traverseBottomUp(visitor);
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(PossibleArrayDecl!=null) PossibleArrayDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FormParsDerived1(\n");

        if(FormPars!=null)
            buffer.append(FormPars.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(PossibleArrayDecl!=null)
            buffer.append(PossibleArrayDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FormParsDerived1]");
        return buffer.toString();
    }
}
