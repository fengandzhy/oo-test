package org.frank.calculator.exception;

import com.sun.istack.internal.NotNull;

public class CalculatorException extends RuntimeException{
    
    public CalculatorException(@NotNull String message){
        super(message);
    }
}
