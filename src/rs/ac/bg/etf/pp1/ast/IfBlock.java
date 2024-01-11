// generated with ast extension for cup
// version 0.8
// 11/0/2024 15:2:59


package rs.ac.bg.etf.pp1.ast;

public class IfBlock implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private IfConditionEndDetected IfConditionEndDetected;
    private Statement Statement;

    public IfBlock (IfConditionEndDetected IfConditionEndDetected, Statement Statement) {
        this.IfConditionEndDetected=IfConditionEndDetected;
        if(IfConditionEndDetected!=null) IfConditionEndDetected.setParent(this);
        this.Statement=Statement;
        if(Statement!=null) Statement.setParent(this);
    }

    public IfConditionEndDetected getIfConditionEndDetected() {
        return IfConditionEndDetected;
    }

    public void setIfConditionEndDetected(IfConditionEndDetected IfConditionEndDetected) {
        this.IfConditionEndDetected=IfConditionEndDetected;
    }

    public Statement getStatement() {
        return Statement;
    }

    public void setStatement(Statement Statement) {
        this.Statement=Statement;
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
        if(IfConditionEndDetected!=null) IfConditionEndDetected.accept(visitor);
        if(Statement!=null) Statement.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(IfConditionEndDetected!=null) IfConditionEndDetected.traverseTopDown(visitor);
        if(Statement!=null) Statement.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(IfConditionEndDetected!=null) IfConditionEndDetected.traverseBottomUp(visitor);
        if(Statement!=null) Statement.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("IfBlock(\n");

        if(IfConditionEndDetected!=null)
            buffer.append(IfConditionEndDetected.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Statement!=null)
            buffer.append(Statement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [IfBlock]");
        return buffer.toString();
    }
}
