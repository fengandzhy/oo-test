package org.frank.calculator.operation.strategy.impl;

import com.sun.istack.internal.NotNull;
import org.frank.calculator.operation.AbstractTwoOperandsOperation;
import org.frank.calculator.operation.strategy.OperationStrategy;

public class AdditionOperationStrategy extends AbstractTwoOperandsOperation implements OperationStrategy {
    
    @Override
    public double calculate(@NotNull double ... operands) {
        this.valid(operands);     
        return operands[0] + operands[1];
    }
}
