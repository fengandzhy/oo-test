package org.frank.calculator.factory;


import org.frank.calculator.exception.CalculatorException;
import org.frank.calculator.operation.strategy.OperationStrategy;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class OperationStrategiesFactory {
    private final static Map<String,String> strategyMap = new HashMap<>();
    
    public OperationStrategiesFactory(@NotNull InputStream inputStream) {
        Properties properties = new Properties();        
        try {
            properties.load(inputStream);
            for (String key : properties.stringPropertyNames()) {
                strategyMap.put(key, properties.getProperty(key));
            }
        } catch (IOException e) {
            throw new RuntimeException("Strategy file read error.");
        }
    }
    
    @NotNull
    public OperationStrategy createOperationStrategy(@NotNull String Operation){
        String operationStrategyName = strategyMap.get(Operation);
        if(operationStrategyName == null){
            throw new CalculatorException("Incorrect Operation");
        }
        OperationStrategy operationStrategy;
        try {
            operationStrategy = (OperationStrategy) Class.forName(operationStrategyName).newInstance();
        } catch (Exception e) {
            throw new CalculatorException("Create Strategy Error");        
        }
        return  operationStrategy;
    }
    
    
    public  Map<String,String> getStrategyMap(){
        return strategyMap;
    }
}
