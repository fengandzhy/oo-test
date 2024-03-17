package org.frank.calculator.operation.strategy.impl;

import org.frank.calculator.operation.AbstractTwoOperandsOperationTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SubtractionOperationStrategyTest extends AbstractTwoOperandsOperationTest {
    
    @Test
    public void whenInputTwoOperands_thenReturnSubtractionResult(){
        SubtractionOperationStrategy strategy = new SubtractionOperationStrategy();
        double result = strategy.calculate(1,2);
        assertEquals(-1.0,result);
        result = strategy.calculate(1,-2);
        assertEquals(3.0,result);
    }

    @Test
    public void whenInputNotTwoOperands_thenThrowCalculatorException(){
        SubtractionOperationStrategy strategy = new SubtractionOperationStrategy();
        this.whenInputNotTwoOperands_thenThrowCalculatorException(strategy);
    }
}
