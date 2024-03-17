package org.frank.calculator.operation;

import org.frank.calculator.exception.CalculatorException;

import static org.junit.jupiter.api.Assertions.*;

public class AbstractTwoOperandsOperationTest {
    
    public void whenInputNotTwoOperands_thenThrowCalculatorException(AbstractTwoOperandsOperation abstractTwoOperandsOperation){        
        Exception exception = assertThrows(CalculatorException.class, () -> abstractTwoOperandsOperation.valid(1));
        assertEquals("The sum of operand is incorrect", exception.getMessage());

        exception = assertThrows(CalculatorException.class, () -> abstractTwoOperandsOperation.valid(1,2,3));
        assertEquals("The sum of operand is incorrect", exception.getMessage());
    }
}
