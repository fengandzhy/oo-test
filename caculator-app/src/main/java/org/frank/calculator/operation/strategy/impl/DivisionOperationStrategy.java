package org.frank.calculator.operation.strategy.impl;

import org.frank.calculator.exception.CalculatorException;
import org.frank.calculator.operation.AbstractTwoOperandsOperation;
import org.frank.calculator.operation.strategy.OperationStrategy;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;

public class DivisionOperationStrategy extends AbstractTwoOperandsOperation implements OperationStrategy {
    @Override
    public double calculate(@NotNull double ... operands) {
        this.valid(operands);
        if(operands[1] == 0){
            throw new CalculatorException("The division is zero");
        }
        BigDecimal dividend = new BigDecimal(String.valueOf(operands[0]));
        BigDecimal divisor = new BigDecimal(String.valueOf(operands[1]));
        BigDecimal result = dividend.divide(divisor);
        return result.doubleValue();
    }
}
