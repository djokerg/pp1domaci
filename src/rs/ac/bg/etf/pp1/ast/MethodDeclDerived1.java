// generated with ast extension for cup
// version 0.8
// 28/11/2023 23:51:7


package rs.ac.bg.etf.pp1.ast;

public class MethodDeclDerived1 extends MethodDecl {

    private TypeOrVoid TypeOrVoid;
    private PossibleFormPars PossibleFormPars;
    private VarDeclList VarDeclList;
    private StatementList StatementList;

    public MethodDeclDerived1 (TypeOrVoid TypeOrVoid, PossibleFormPars PossibleFormPars, VarDeclList VarDeclList, StatementList StatementList) {
        this.TypeOrVoid=TypeOrVoid;
        if(TypeOrVoid!=null) TypeOrVoid.setParent(this);
        this.PossibleFormPars=PossibleFormPars;
        if(PossibleFormPars!=null) PossibleFormPars.setParent(this);
        this.VarDeclList=VarDeclList;
        if(VarDeclList!=null) VarDeclList.setParent(this);
        this.StatementList=StatementList;
        if(StatementList!=null) StatementList.setParent(this);
    }

    public TypeOrVoid getTypeOrVoid() {
        return TypeOrVoid;
    }

    public void setTypeOrVoid(TypeOrVoid TypeOrVoid) {
        this.TypeOrVoid=TypeOrVoid;
    }

    public PossibleFormPars getPossibleFormPars() {
        return PossibleFormPars;
    }

    public void setPossibleFormPars(PossibleFormPars PossibleFormPars) {
        this.PossibleFormPars=PossibleFormPars;
    }

    public VarDeclList getVarDeclList() {
        return VarDeclList;
    }

    public void setVarDeclList(VarDeclList VarDeclList) {
        this.VarDeclList=VarDeclList;
    }

    public StatementList getStatementList() {
        return StatementList;
    }

    public void setStatementList(StatementList StatementList) {
        this.StatementList=StatementList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(TypeOrVoid!=null) TypeOrVoid.accept(visitor);
        if(PossibleFormPars!=null) PossibleFormPars.accept(visitor);
        if(VarDeclList!=null) VarDeclList.accept(visitor);
        if(StatementList!=null) StatementList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(TypeOrVoid!=null) TypeOrVoid.traverseTopDown(visitor);
        if(PossibleFormPars!=null) PossibleFormPars.traverseTopDown(visitor);
        if(VarDeclList!=null) VarDeclList.traverseTopDown(visitor);
        if(StatementList!=null) StatementList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(TypeOrVoid!=null) TypeOrVoid.traverseBottomUp(visitor);
        if(PossibleFormPars!=null) PossibleFormPars.traverseBottomUp(visitor);
        if(VarDeclList!=null) VarDeclList.traverseBottomUp(visitor);
        if(StatementList!=null) StatementList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MethodDeclDerived1(\n");

        if(TypeOrVoid!=null)
            buffer.append(TypeOrVoid.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(PossibleFormPars!=null)
            buffer.append(PossibleFormPars.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarDeclList!=null)
            buffer.append(VarDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(StatementList!=null)
            buffer.append(StatementList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MethodDeclDerived1]");
        return buffer.toString();
    }
}
