package com.cngroup.calculator.operations.factory;

import com.cngroup.calculator.operations.AbstractOperation;
import com.cngroup.calculator.operations.AdditionOperation;
import com.cngroup.calculator.operations.ApplyOperation;
import com.cngroup.calculator.operations.DivideOperation;
import com.cngroup.calculator.operations.MultiplyOperation;
import com.cngroup.calculator.operations.SubtractOperation;
import com.cngroup.calculator.operations.exception.InvalidOperationStringException;
import com.cngroup.calculator.operations.exception.OperationExecutionException;

import java.math.BigDecimal;

import static java.util.Arrays.stream;

/**
 * Holds types of available operations.
 * Each operation has literal (corresponds 1:1 to the symbol on the input)
 */
public enum OperationTypes {

    ADD("add"),
    SUBTRACT("subtract"),
    MULTIPLY("multiply"),
    DIVIDE("divide"),
    APPLY("apply");

    OperationTypes(String literal) {
        this.literal = literal;
    }

    private String literal;

    public String getLiteral() {
        return literal;
    }

    /**
     * Convenient method for creating operation instance from this enum value.

     * @param argument operation argument
     */
    public AbstractOperation createOperation(BigDecimal argument) {
        switch (this) {
            case ADD: return new AdditionOperation(argument);
            case SUBTRACT: return new SubtractOperation(argument);
            case MULTIPLY: return new MultiplyOperation(argument);
            case DIVIDE: return new DivideOperation(argument);
            case APPLY: return new ApplyOperation(argument);
            default: throw new OperationExecutionException(String.format("Unknown operation %s", this));
        }
    }

    public static OperationTypes fromLiteral(String literal) {
        return stream(values())
            .filter(ot -> ot.literal.equalsIgnoreCase(literal))
            .findFirst()
            .orElseThrow(() -> new InvalidOperationStringException(String.format("Unknown operation literal '%s'", literal)));
    }
}
