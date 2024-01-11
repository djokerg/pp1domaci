// generated with ast extension for cup
// version 0.8
// 11/0/2024 10:52:27


package rs.ac.bg.etf.pp1.ast;

public class ConditionBITOR extends Condition {

    private ORBlockDetected ORBlockDetected;
    private CondTerm CondTerm;

    public ConditionBITOR (ORBlockDetected ORBlockDetected, CondTerm CondTerm) {
        this.ORBlockDetected=ORBlockDetected;
        if(ORBlockDetected!=null) ORBlockDetected.setParent(this);
        this.CondTerm=CondTerm;
        if(CondTerm!=null) CondTerm.setParent(this);
    }

    public ORBlockDetected getORBlockDetected() {
        return ORBlockDetected;
    }

    public void setORBlockDetected(ORBlockDetected ORBlockDetected) {
        this.ORBlockDetected=ORBlockDetected;
    }

    public CondTerm getCondTerm() {
        return CondTerm;
    }

    public void setCondTerm(CondTerm CondTerm) {
        this.CondTerm=CondTerm;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ORBlockDetected!=null) ORBlockDetected.accept(visitor);
        if(CondTerm!=null) CondTerm.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ORBlockDetected!=null) ORBlockDetected.traverseTopDown(visitor);
        if(CondTerm!=null) CondTerm.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ORBlockDetected!=null) ORBlockDetected.traverseBottomUp(visitor);
        if(CondTerm!=null) CondTerm.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConditionBITOR(\n");

        if(ORBlockDetected!=null)
            buffer.append(ORBlockDetected.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(CondTerm!=null)
            buffer.append(CondTerm.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConditionBITOR]");
        return buffer.toString();
    }
}
