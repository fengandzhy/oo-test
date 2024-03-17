package org.frank.calculator.operation.strategy.impl;

import org.frank.calculator.exception.CalculatorException;
import org.frank.calculator.operation.AbstractTwoOperandsOperationTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DivisionOperationStrategyTest extends AbstractTwoOperandsOperationTest {

    @Test
    public void whenInputTwoOperands_thenReturnDivisionResult(){
        DivisionOperationStrategy strategy = new DivisionOperationStrategy();
        double result = strategy.calculate(6,2);
        assertEquals(3.0,result);
        result = strategy.calculate(0.3,-0.2);
        assertEquals(-1.5,result);
    }

    @Test
    public void whenInputZeroDivision_thenThrowCalculationException(){
        DivisionOperationStrategy strategy = new DivisionOperationStrategy();
        Exception exception = assertThrows(CalculatorException.class, () -> strategy.calculate(1,0));
        assertEquals("The division is zero", exception.getMessage());        
    }

    @Test
    public void whenInputNotTwoOperands_thenThrowCalculatorException(){
        DivisionOperationStrategy strategy = new DivisionOperationStrategy();
        this.whenInputNotTwoOperands_thenThrowCalculatorException(strategy);
    }
}
