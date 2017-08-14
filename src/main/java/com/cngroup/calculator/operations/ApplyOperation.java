package com.cngroup.calculator.operations;

import java.math.BigDecimal;

import static com.cngroup.calculator.operations.factory.OperationTypes.APPLY;

public final class ApplyOperation extends AbstractOperation {

    public ApplyOperation(BigDecimal argument) {
        super(argument, APPLY);
    }

    @Override
    public BigDecimal perform(BigDecimal argument) {
        return argument;
    }
}
