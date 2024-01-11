// generated with ast extension for cup
// version 0.8
// 11/0/2024 10:52:27


package rs.ac.bg.etf.pp1.ast;

public class IfStatement extends Statement {

    private IfBlock IfBlock;

    public IfStatement (IfBlock IfBlock) {
        this.IfBlock=IfBlock;
        if(IfBlock!=null) IfBlock.setParent(this);
    }

    public IfBlock getIfBlock() {
        return IfBlock;
    }

    public void setIfBlock(IfBlock IfBlock) {
        this.IfBlock=IfBlock;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(IfBlock!=null) IfBlock.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(IfBlock!=null) IfBlock.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(IfBlock!=null) IfBlock.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("IfStatement(\n");

        if(IfBlock!=null)
            buffer.append(IfBlock.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [IfStatement]");
        return buffer.toString();
    }
}
