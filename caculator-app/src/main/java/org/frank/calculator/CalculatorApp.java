package org.frank.calculator;

import org.frank.calculator.bean.ExpressionBean;
import org.frank.calculator.factory.OperationStrategiesFactory;
import org.frank.calculator.operation.strategy.OperationStrategy;
import org.frank.calculator.parser.Parser;

import java.util.Scanner;

public class CalculatorApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("please input an expression：");
        String expression = scanner.nextLine();
        scanner.close();
        Parser parser = new Parser();
        ExpressionBean bean = parser.parse(expression);
        OperationStrategiesFactory factory = new OperationStrategiesFactory(CalculatorApp.class.getClassLoader().getSystemResourceAsStream("application.properties"));
        OperationStrategy operationStrategy = factory.createOperationStrategy(bean.getOperation());
        double result = operationStrategy.calculate(bean.getOperands());
        print(result);    
    }

    public static void print(double result){        
        int result1 = (int)result;
        if(result % result1 == 0)
            System.out.println(result1);
        else
            System.out.println(result);
    }
}
