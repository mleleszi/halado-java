package hu.meiit.haladojava.calculator;

public class Operation {
    private Double operandA;
    private Double operandB;
    private Character operator;

    public Operation() {
    }

    public Operation(Double operandA, Double operandB, Character operator) {
        this.operandA = operandA;
        this.operandB = operandB;
        this.operator = operator;
    }

    public Double getOperandA() {
        return operandA;
    }

    public void setOperandA(Double operandA) {
        this.operandA = operandA;
    }

    public Double getOperandB() {
        return operandB;
    }

    public void setOperandB(Double operandB) {
        this.operandB = operandB;
    }

    public Character getOperator() {
        return operator;
    }

    public void setOperator(Character operator) {
        this.operator = operator;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "operandA=" + operandA +
                ", operandB=" + operandB +
                ", operator=" + operator +
                '}';
    }
}
