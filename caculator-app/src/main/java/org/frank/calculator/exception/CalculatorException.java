package org.frank.calculator.exception;


import org.jetbrains.annotations.NotNull;

public class CalculatorException extends RuntimeException{
    
    public CalculatorException(@NotNull String message){
        super(message);
    }
}
