package org.frank.calculator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CalculatorAppTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void testPrint_thenShouldPrintCorrectly() {        
        CalculatorApp.print(5.0);
        assertEquals("5\r\n", outContent.toString());

        outContent.reset(); 

        CalculatorApp.print(5.1);
        assertEquals("5.1\r\n", outContent.toString());
    }
}
