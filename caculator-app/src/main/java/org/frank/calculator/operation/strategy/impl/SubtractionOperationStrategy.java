package org.frank.calculator.operation.strategy.impl;

import org.jetbrains.annotations.NotNull;
import org.frank.calculator.operation.AbstractTwoOperandsOperation;
import org.frank.calculator.operation.strategy.OperationStrategy;

import java.math.BigDecimal;

public class SubtractionOperationStrategy extends AbstractTwoOperandsOperation implements OperationStrategy {
    @Override
    public double calculate(@NotNull double ... operands) {
        this.valid(operands);
        BigDecimal minuend = new BigDecimal(String.valueOf(operands[0]));        
        BigDecimal subtrahend = new BigDecimal(String.valueOf(operands[1]));
        BigDecimal result = minuend.subtract(subtrahend);        
        return  result.doubleValue();
    }
}
