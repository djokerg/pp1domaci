// generated with ast extension for cup
// version 0.8
// 11/0/2024 15:2:59


package rs.ac.bg.etf.pp1.ast;

public class IfConditionEndDetectedCorrect extends IfConditionEndDetected {

    private IfStartDetected IfStartDetected;
    private Condition Condition;

    public IfConditionEndDetectedCorrect (IfStartDetected IfStartDetected, Condition Condition) {
        this.IfStartDetected=IfStartDetected;
        if(IfStartDetected!=null) IfStartDetected.setParent(this);
        this.Condition=Condition;
        if(Condition!=null) Condition.setParent(this);
    }

    public IfStartDetected getIfStartDetected() {
        return IfStartDetected;
    }

    public void setIfStartDetected(IfStartDetected IfStartDetected) {
        this.IfStartDetected=IfStartDetected;
    }

    public Condition getCondition() {
        return Condition;
    }

    public void setCondition(Condition Condition) {
        this.Condition=Condition;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(IfStartDetected!=null) IfStartDetected.accept(visitor);
        if(Condition!=null) Condition.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(IfStartDetected!=null) IfStartDetected.traverseTopDown(visitor);
        if(Condition!=null) Condition.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(IfStartDetected!=null) IfStartDetected.traverseBottomUp(visitor);
        if(Condition!=null) Condition.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("IfConditionEndDetectedCorrect(\n");

        if(IfStartDetected!=null)
            buffer.append(IfStartDetected.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Condition!=null)
            buffer.append(Condition.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [IfConditionEndDetectedCorrect]");
        return buffer.toString();
    }
}
