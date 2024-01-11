// generated with ast extension for cup
// version 0.8
// 11/0/2024 15:2:59


package rs.ac.bg.etf.pp1.ast;

public class FactorCall extends Factor {

    private Designator Designator;
    private FactorCallPossiblePars FactorCallPossiblePars;

    public FactorCall (Designator Designator, FactorCallPossiblePars FactorCallPossiblePars) {
        this.Designator=Designator;
        if(Designator!=null) Designator.setParent(this);
        this.FactorCallPossiblePars=FactorCallPossiblePars;
        if(FactorCallPossiblePars!=null) FactorCallPossiblePars.setParent(this);
    }

    public Designator getDesignator() {
        return Designator;
    }

    public void setDesignator(Designator Designator) {
        this.Designator=Designator;
    }

    public FactorCallPossiblePars getFactorCallPossiblePars() {
        return FactorCallPossiblePars;
    }

    public void setFactorCallPossiblePars(FactorCallPossiblePars FactorCallPossiblePars) {
        this.FactorCallPossiblePars=FactorCallPossiblePars;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Designator!=null) Designator.accept(visitor);
        if(FactorCallPossiblePars!=null) FactorCallPossiblePars.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Designator!=null) Designator.traverseTopDown(visitor);
        if(FactorCallPossiblePars!=null) FactorCallPossiblePars.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Designator!=null) Designator.traverseBottomUp(visitor);
        if(FactorCallPossiblePars!=null) FactorCallPossiblePars.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FactorCall(\n");

        if(Designator!=null)
            buffer.append(Designator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(FactorCallPossiblePars!=null)
            buffer.append(FactorCallPossiblePars.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FactorCall]");
        return buffer.toString();
    }
}
