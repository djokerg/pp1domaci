// generated with ast extension for cup
// version 0.8
// 11/0/2024 10:52:27


package rs.ac.bg.etf.pp1.ast;

public class FormParsList extends FormPars {

    private FormPars FormPars;
    private LastFormParam LastFormParam;

    public FormParsList (FormPars FormPars, LastFormParam LastFormParam) {
        this.FormPars=FormPars;
        if(FormPars!=null) FormPars.setParent(this);
        this.LastFormParam=LastFormParam;
        if(LastFormParam!=null) LastFormParam.setParent(this);
    }

    public FormPars getFormPars() {
        return FormPars;
    }

    public void setFormPars(FormPars FormPars) {
        this.FormPars=FormPars;
    }

    public LastFormParam getLastFormParam() {
        return LastFormParam;
    }

    public void setLastFormParam(LastFormParam LastFormParam) {
        this.LastFormParam=LastFormParam;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(FormPars!=null) FormPars.accept(visitor);
        if(LastFormParam!=null) LastFormParam.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(FormPars!=null) FormPars.traverseTopDown(visitor);
        if(LastFormParam!=null) LastFormParam.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(FormPars!=null) FormPars.traverseBottomUp(visitor);
        if(LastFormParam!=null) LastFormParam.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FormParsList(\n");

        if(FormPars!=null)
            buffer.append(FormPars.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(LastFormParam!=null)
            buffer.append(LastFormParam.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FormParsList]");
        return buffer.toString();
    }
}
