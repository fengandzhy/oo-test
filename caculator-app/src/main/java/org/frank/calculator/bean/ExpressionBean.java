package org.frank.calculator.bean;

public class ExpressionBean {
    
    private double[] operands;
    private String operation;

    public double[] getOperands() {
        return operands;
    }

    public void setOperands(double[] operands) {
        this.operands = operands;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }
}
