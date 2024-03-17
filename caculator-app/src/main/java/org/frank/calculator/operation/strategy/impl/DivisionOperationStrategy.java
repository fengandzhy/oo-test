package org.frank.calculator.operation.strategy.impl;

import com.sun.istack.internal.NotNull;
import org.frank.calculator.exception.CalculatorException;
import org.frank.calculator.operation.AbstractTwoOperandsOperation;
import org.frank.calculator.operation.strategy.OperationStrategy;

public class DivisionOperationStrategy extends AbstractTwoOperandsOperation implements OperationStrategy {
    @Override
    public double calculate(@NotNull double ... operands) {
        this.valid(operands);
        if(operands[1] == 0){
            throw new CalculatorException("The division is zero");
        }
        return operands[0] / operands[1];
    }
}
