package com.cngroup.calculator.operations;

import java.math.BigDecimal;

import static com.cngroup.calculator.operations.factory.OperationTypes.ADD;

/**
 * Performs arithmetic addition
 */
public final class AdditionOperation extends AbstractOperation {

    public AdditionOperation(BigDecimal argument) {
        super(argument, ADD);
    }

    @Override
    public BigDecimal perform(BigDecimal argument) {
        return this.getArgument().add(argument);
    }
}
