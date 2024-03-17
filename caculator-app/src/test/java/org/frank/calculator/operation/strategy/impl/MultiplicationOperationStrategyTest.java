package org.frank.calculator.operation.strategy.impl;

import org.frank.calculator.operation.AbstractTwoOperandsOperationTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultiplicationOperationStrategyTest extends AbstractTwoOperandsOperationTest {

    @Test
    public void whenInputTwoOperands_thenReturnMultiplicationResult(){
        MultiplicationOperationStrategy strategy = new MultiplicationOperationStrategy();
        double result = strategy.calculate(6,2);
        assertEquals(12.0,result);
        result = strategy.calculate(0.3,-0.5);
        assertEquals(-0.15,result);
    }

    @Test
    public void whenInputNotTwoOperands_thenThrowCalculatorException(){
        MultiplicationOperationStrategy strategy = new MultiplicationOperationStrategy();
        this.whenInputNotTwoOperands_thenThrowCalculatorException(strategy);
    }
}
