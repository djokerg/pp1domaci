// generated with ast extension for cup
// version 0.8
// 11/0/2024 15:2:59


package rs.ac.bg.etf.pp1.ast;

public class ClassDecl implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private String I1;
    private OptionalExtends OptionalExtends;
    private StaticVarDeclList StaticVarDeclList;
    private StaticInitializerHelper StaticInitializerHelper;
    private VarDeclList VarDeclList;
    private OtpionalMethodDeclList OtpionalMethodDeclList;

    public ClassDecl (String I1, OptionalExtends OptionalExtends, StaticVarDeclList StaticVarDeclList, StaticInitializerHelper StaticInitializerHelper, VarDeclList VarDeclList, OtpionalMethodDeclList OtpionalMethodDeclList) {
        this.I1=I1;
        this.OptionalExtends=OptionalExtends;
        if(OptionalExtends!=null) OptionalExtends.setParent(this);
        this.StaticVarDeclList=StaticVarDeclList;
        if(StaticVarDeclList!=null) StaticVarDeclList.setParent(this);
        this.StaticInitializerHelper=StaticInitializerHelper;
        if(StaticInitializerHelper!=null) StaticInitializerHelper.setParent(this);
        this.VarDeclList=VarDeclList;
        if(VarDeclList!=null) VarDeclList.setParent(this);
        this.OtpionalMethodDeclList=OtpionalMethodDeclList;
        if(OtpionalMethodDeclList!=null) OtpionalMethodDeclList.setParent(this);
    }

    public String getI1() {
        return I1;
    }

    public void setI1(String I1) {
        this.I1=I1;
    }

    public OptionalExtends getOptionalExtends() {
        return OptionalExtends;
    }

    public void setOptionalExtends(OptionalExtends OptionalExtends) {
        this.OptionalExtends=OptionalExtends;
    }

    public StaticVarDeclList getStaticVarDeclList() {
        return StaticVarDeclList;
    }

    public void setStaticVarDeclList(StaticVarDeclList StaticVarDeclList) {
        this.StaticVarDeclList=StaticVarDeclList;
    }

    public StaticInitializerHelper getStaticInitializerHelper() {
        return StaticInitializerHelper;
    }

    public void setStaticInitializerHelper(StaticInitializerHelper StaticInitializerHelper) {
        this.StaticInitializerHelper=StaticInitializerHelper;
    }

    public VarDeclList getVarDeclList() {
        return VarDeclList;
    }

    public void setVarDeclList(VarDeclList VarDeclList) {
        this.VarDeclList=VarDeclList;
    }

    public OtpionalMethodDeclList getOtpionalMethodDeclList() {
        return OtpionalMethodDeclList;
    }

    public void setOtpionalMethodDeclList(OtpionalMethodDeclList OtpionalMethodDeclList) {
        this.OtpionalMethodDeclList=OtpionalMethodDeclList;
    }

    public SyntaxNode getParent() {
        return parent;
    }

    public void setParent(SyntaxNode parent) {
        this.parent=parent;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line=line;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(OptionalExtends!=null) OptionalExtends.accept(visitor);
        if(StaticVarDeclList!=null) StaticVarDeclList.accept(visitor);
        if(StaticInitializerHelper!=null) StaticInitializerHelper.accept(visitor);
        if(VarDeclList!=null) VarDeclList.accept(visitor);
        if(OtpionalMethodDeclList!=null) OtpionalMethodDeclList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(OptionalExtends!=null) OptionalExtends.traverseTopDown(visitor);
        if(StaticVarDeclList!=null) StaticVarDeclList.traverseTopDown(visitor);
        if(StaticInitializerHelper!=null) StaticInitializerHelper.traverseTopDown(visitor);
        if(VarDeclList!=null) VarDeclList.traverseTopDown(visitor);
        if(OtpionalMethodDeclList!=null) OtpionalMethodDeclList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(OptionalExtends!=null) OptionalExtends.traverseBottomUp(visitor);
        if(StaticVarDeclList!=null) StaticVarDeclList.traverseBottomUp(visitor);
        if(StaticInitializerHelper!=null) StaticInitializerHelper.traverseBottomUp(visitor);
        if(VarDeclList!=null) VarDeclList.traverseBottomUp(visitor);
        if(OtpionalMethodDeclList!=null) OtpionalMethodDeclList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ClassDecl(\n");

        buffer.append(" "+tab+I1);
        buffer.append("\n");

        if(OptionalExtends!=null)
            buffer.append(OptionalExtends.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(StaticVarDeclList!=null)
            buffer.append(StaticVarDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(StaticInitializerHelper!=null)
            buffer.append(StaticInitializerHelper.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarDeclList!=null)
            buffer.append(VarDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(OtpionalMethodDeclList!=null)
            buffer.append(OtpionalMethodDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ClassDecl]");
        return buffer.toString();
    }
}
