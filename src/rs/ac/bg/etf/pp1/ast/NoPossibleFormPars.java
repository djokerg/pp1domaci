// generated with ast extension for cup
// version 0.8
// 11/0/2024 15:2:59


package rs.ac.bg.etf.pp1.ast;

public class NoPossibleFormPars extends PossibleFormPars {

    public NoPossibleFormPars () {
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("NoPossibleFormPars(\n");

        buffer.append(tab);
        buffer.append(") [NoPossibleFormPars]");
        return buffer.toString();
    }
}
