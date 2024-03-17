package org.frank.calculator.operation.strategy.impl;


import org.frank.calculator.operation.AbstractTwoOperandsOperation;
import org.frank.calculator.operation.strategy.OperationStrategy;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;

public class AdditionOperationStrategy extends AbstractTwoOperandsOperation implements OperationStrategy {
    
    @Override
    public double calculate(@NotNull double ... operands) {
        this.valid(operands);
        BigDecimal addend = new BigDecimal(String.valueOf(operands[0]));
        BigDecimal summand = new BigDecimal(String.valueOf(operands[1]));
        BigDecimal result = addend.add(summand);
        return result.doubleValue();
    }
}
