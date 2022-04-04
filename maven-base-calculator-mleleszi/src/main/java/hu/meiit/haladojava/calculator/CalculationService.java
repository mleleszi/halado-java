package hu.meiit.haladojava.calculator;

public class CalculationService {

    public Double calculate(Operation operation) {
        if (operation == null)
            return null;
        switch (operation.getOperator()) {
            case '+': return add(operation.getOperandA(), operation.getOperandB());
            case '-': return substract(operation.getOperandA(), operation.getOperandB());
            case '/': return divide(operation.getOperandA(), operation.getOperandB());
            case '*': return multiply(operation.getOperandA(), operation.getOperandB());
        }
        return null;
    }

    private Double add(Double a, Double b) {
        return a + b;
    }

    private Double substract(Double a, Double b) {
        return a - b;
    }

    private Double multiply(Double a, Double b) {
        return a * b;
    }

    private Double divide(Double a, Double b) {
        if(b == 0) return null;
        return a / b;
    }
}
