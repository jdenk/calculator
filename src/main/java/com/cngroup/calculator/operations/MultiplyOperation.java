package com.cngroup.calculator.operations;

import java.math.BigDecimal;

import static com.cngroup.calculator.operations.factory.OperationTypes.MULTIPLY;

/**
 * Performs arithmetic multiplication.
 */
public final class MultiplyOperation extends AbstractOperation {

    public MultiplyOperation(BigDecimal argument) {
        super(argument, MULTIPLY);
    }

    @Override
    public BigDecimal perform(BigDecimal argument) {
        return this.getArgument().multiply(argument);
    }
}
