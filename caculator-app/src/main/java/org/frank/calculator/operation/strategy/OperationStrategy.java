package org.frank.calculator.operation.strategy;

import org.jetbrains.annotations.NotNull;

public interface OperationStrategy {
    double calculate(@NotNull double ... operands);
}
