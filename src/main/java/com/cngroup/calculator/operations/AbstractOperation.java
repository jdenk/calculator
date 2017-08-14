package com.cngroup.calculator.operations;

import com.cngroup.calculator.operations.factory.OperationTypes;

import java.math.BigDecimal;
import java.util.Objects;

import static org.apache.commons.lang3.Validate.notNull;

/**
 * Base class for all operations. Each operation has a type {@link #getOperationType()}
 * and certain argument of the calculation {@link #getArgument()}. Operation can be performed
 * using method {@link #perform(BigDecimal)}
 */
public abstract class AbstractOperation {

    private final BigDecimal argument;
    private final OperationTypes operationType;

    AbstractOperation(BigDecimal argument, OperationTypes operationType) {
        notNull(argument, "argument");
        notNull(operationType, "operationType");

        this.argument = argument;
        this.operationType = operationType;
    }

    public final OperationTypes getOperationType() {
        return operationType;
    }

    public final BigDecimal getArgument() {
        return argument;
    }

    public abstract BigDecimal perform(BigDecimal argument);

    @Override
    public String toString() {
        return "AbstractOperation{" +
            "argument=" + argument +
            ", operationType=" + operationType +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractOperation that = (AbstractOperation) o;
        return Objects.equals(argument, that.argument) &&
            operationType == that.operationType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(argument, operationType);
    }
}
