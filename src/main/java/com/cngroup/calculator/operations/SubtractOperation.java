package com.cngroup.calculator.operations;

import java.math.BigDecimal;

import static com.cngroup.calculator.operations.factory.OperationTypes.SUBTRACT;

/**
 * Performs arithmetic subtraction.
 * Argument of this operation is subtracted from the argument of {@link #perform(BigDecimal)} method.
 */
public final class SubtractOperation extends AbstractOperation {

    public SubtractOperation(BigDecimal argument) {
        super(argument, SUBTRACT);
    }

    @Override
    public BigDecimal perform(BigDecimal argument) {
        return argument.subtract(this.getArgument());
    }
}
