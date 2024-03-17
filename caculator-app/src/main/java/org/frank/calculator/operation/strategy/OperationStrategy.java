package org.frank.calculator.operation.strategy;

import com.sun.istack.internal.NotNull;

public interface OperationStrategy {
    double calculate(@NotNull double ... operands);
}
