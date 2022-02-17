package hu.me.advancedjava;

public class Operands {
    private String a;
    private String b;

    public Operands() {
    }

    public Operands(String a, String b) {
        this.a = a;
        this.b = b;
    }

    public String getA() {
        return a;
    }

    public Operands setA(String a) {
        this.a = a;
        return this;
    }

    public String getB() {
        return b;
    }

    public Operands setB(String b) {
        this.b = b;
        return this;
    }
}
