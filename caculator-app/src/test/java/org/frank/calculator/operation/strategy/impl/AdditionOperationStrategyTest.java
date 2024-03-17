package org.frank.calculator.operation.strategy.impl;

import org.frank.calculator.operation.AbstractTwoOperandsOperationTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AdditionOperationStrategyTest extends AbstractTwoOperandsOperationTest {
    
    @Test
    public void whenInputTwoOperands_thenReturnAdditionResult(){
        AdditionOperationStrategy strategy = new AdditionOperationStrategy();
        double result = strategy.calculate(1,2);
        assertEquals(3.0,result);
        result = strategy.calculate(0.7,-2.1);
        assertEquals(-1.4,result);       
    }

    @Test
    public void whenInputNotTwoOperands_thenThrowCalculatorException(){
        AdditionOperationStrategy strategy = new AdditionOperationStrategy();
        this.whenInputNotTwoOperands_thenThrowCalculatorException(strategy);             
    }
}
