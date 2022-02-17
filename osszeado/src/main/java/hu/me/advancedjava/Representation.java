package hu.me.advancedjava;

public class Representation {
    private String[] args;

    public Representation(String[] args) {
        this.args = args;
    }

    public  void printResult(int result) {
        System.out.println("result: " + result);
    }

    public Operands getOperands() {
        return new Operands().setA(args[0]).setB(args[1]);

    }
}
