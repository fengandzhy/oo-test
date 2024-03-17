package org.frank.calculator.operation;

import com.sun.istack.internal.NotNull;
import org.frank.calculator.exception.CalculatorException;

public abstract class AbstractTwoOperandsOperation {
    
    public void valid(@NotNull double ... operands) {
        if(operands.length != 2){
            throw new CalculatorException("The sum of operand is incorrect");
        }        
    }
}
