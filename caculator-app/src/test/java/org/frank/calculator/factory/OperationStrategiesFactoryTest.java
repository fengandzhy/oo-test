package org.frank.calculator.factory;


import org.frank.calculator.exception.CalculatorException;
import org.frank.calculator.operation.strategy.OperationStrategy;
import org.frank.calculator.operation.strategy.impl.AdditionOperationStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;


public class OperationStrategiesFactoryTest {

    private OperationStrategiesFactory factory;

    @BeforeEach
    public void setUpStreams() {
        String mockConfig = "+=org.frank.calculator.operation.strategy.impl.AdditionOperationStrategy\n-=org.frank.calculator.operation.strategy.impl.SubtractionOperationStrategy";
        InputStream mockInputStream = new ByteArrayInputStream(mockConfig.getBytes());
        factory = new OperationStrategiesFactory(mockInputStream);
    }

    @Test
    public void whenFactoryCreated_thenStrategiesShouldLoaded() {        
        Map<String, String> strategyMap = factory.getStrategyMap();
        assertTrue(strategyMap.containsKey("+"));
        assertTrue(strategyMap.containsKey("-"));
        assertTrue(strategyMap.containsValue("org.frank.calculator.operation.strategy.impl.AdditionOperationStrategy"));
        assertTrue(strategyMap.containsValue("org.frank.calculator.operation.strategy.impl.SubtractionOperationStrategy"));
        assertEquals("org.frank.calculator.operation.strategy.impl.AdditionOperationStrategy", strategyMap.get("+"));
    }

    @Test
    public void whenCreateNotExistOperation_thenFailWithCalculatorException() {
        Exception exception = assertThrows(CalculatorException.class, () -> factory.createOperationStrategy("*"));
        assertEquals("Incorrect Operation", exception.getMessage());        
    }

    @Test
    public void whenCreateNotExistStrategy_thenFailWithCalculatorException() {
        Map<String, String> strategyMap = factory.getStrategyMap();
        strategyMap.put("tan","org.frank.calculator.operation.strategy.impl.tanOperation");
        Exception exception = assertThrows(CalculatorException.class, () -> factory.createOperationStrategy("tan"));
        assertEquals("Create Strategy Error", exception.getMessage());
    }

    @Test
    public void whenCreateAnExistStrategy_thenNotThrowException() {
        assertDoesNotThrow(() -> {
            OperationStrategy strategy = factory.createOperationStrategy("+");
            assertNotNull(strategy);
            assertTrue(strategy instanceof AdditionOperationStrategy);
        });
    }
}
