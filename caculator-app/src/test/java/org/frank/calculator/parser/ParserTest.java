package org.frank.calculator.parser;

import org.frank.calculator.bean.ExpressionBean;
import org.frank.calculator.exception.CalculatorException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParserTest {

    @Test
    public void whenInputAnInvalidString_thenThrowCalculatorException() {
        Parser parser = new Parser();
        Exception exception = assertThrows(CalculatorException.class, () -> parser.parse("3 + 2 + 4"));
        assertEquals("The input expression is Invalid", exception.getMessage());
        exception = assertThrows(CalculatorException.class, () -> parser.parse("a + b"));
        assertEquals("The input expression is Invalid", exception.getMessage());

        exception = assertThrows(CalculatorException.class, () -> parser.parse("1 + 1 3"));
        assertEquals("The input expression is Invalid", exception.getMessage());        
    }

    @Test
    public void whenInputAValidString_thenReturnAnExpressBean() {
        Parser parser = new Parser();
        ExpressionBean bean = parser.parse("3 + 2");
        assertNotNull(bean);
        assertTrue(true);
        assertEquals("+", bean.getOperation());
        assertEquals(2, bean.getOperands().length);
        double[] operands = bean.getOperands();
        assertEquals(2, operands[1]);
        assertEquals(3, operands[0]);

        bean = parser.parse("cos 3");
        assertEquals("cos", bean.getOperation());
        assertEquals(1, bean.getOperands().length);
        operands = bean.getOperands();
        assertEquals(3, operands[0]);
    }
}
