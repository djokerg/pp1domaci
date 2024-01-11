// generated with ast extension for cup
// version 0.8
// 11/0/2024 15:2:59


package rs.ac.bg.etf.pp1.ast;

public class IfConditionError extends IfConditionEndDetected {

    private IfStartDetected IfStartDetected;

    public IfConditionError (IfStartDetected IfStartDetected) {
        this.IfStartDetected=IfStartDetected;
        if(IfStartDetected!=null) IfStartDetected.setParent(this);
    }

    public IfStartDetected getIfStartDetected() {
        return IfStartDetected;
    }

    public void setIfStartDetected(IfStartDetected IfStartDetected) {
        this.IfStartDetected=IfStartDetected;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(IfStartDetected!=null) IfStartDetected.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(IfStartDetected!=null) IfStartDetected.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(IfStartDetected!=null) IfStartDetected.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("IfConditionError(\n");

        if(IfStartDetected!=null)
            buffer.append(IfStartDetected.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [IfConditionError]");
        return buffer.toString();
    }
}
