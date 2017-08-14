package com.cngroup.calculator.operations;

import com.cngroup.calculator.operations.exception.OperationExecutionException;

import java.math.BigDecimal;

import static com.cngroup.calculator.operations.factory.OperationTypes.DIVIDE;
import static java.lang.String.format;
import static java.math.BigDecimal.ZERO;
import static java.math.RoundingMode.HALF_UP;

/**
 * Performs arithmetic division.
 * Argument of the {@link #perform(BigDecimal)} method is divided by the argument of this operation.
 */
public final class DivideOperation extends AbstractOperation {
    private static final int SCALE = 10;

    public DivideOperation(BigDecimal argument) {
        super(argument, DIVIDE);

        if(ZERO .equals(argument)) {
            throw new OperationExecutionException(
                format("Operation %s can't be performed with 0 argument - division by zero problem", DIVIDE)
            );
        }
    }

    @Override
    public BigDecimal perform(BigDecimal argument) {
        return argument.divide(this.getArgument(), SCALE, HALF_UP);
    }
}
