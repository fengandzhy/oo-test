package org.frank.calculator.parser;

import org.jetbrains.annotations.NotNull;
import org.frank.calculator.bean.ExpressionBean;
import org.frank.calculator.exception.CalculatorException;


public class Parser {

    /**
     * @return A class that encapsulates Operands and Operations.                  
     * 
     * */
    @NotNull
    public ExpressionBean parse(@NotNull String expression){
        String[] expressionStrings = expression.split(" ");
        ExpressionBean bean = new ExpressionBean();
        String operation;
        double[] operands;
        try {
            if(expressionStrings.length == 3){           
                operation = expressionStrings[1];
                operands = new double[]{Double.parseDouble(expressionStrings[0]),Double.parseDouble(expressionStrings[2])};           
            }else if(expressionStrings.length == 2){
                operation = expressionStrings[0];
                operands = new double[]{Double.parseDouble(expressionStrings[1])};
            } else {
                throw new CalculatorException("The input expression is Invalid");
            }
        } catch (NumberFormatException e) {
            throw new CalculatorException("The input expression is Invalid");
        }        
        bean.setOperation(operation);
        bean.setOperands(operands);
        return bean;
    }
}
