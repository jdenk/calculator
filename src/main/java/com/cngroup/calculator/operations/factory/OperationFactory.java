package com.cngroup.calculator.operations.factory;

import com.cngroup.calculator.operations.AbstractOperation;
import com.cngroup.calculator.operations.exception.InvalidOperationStringException;

import java.math.BigDecimal;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

import static java.lang.String.format;
import static org.apache.commons.lang3.Validate.notEmpty;

/**
 * Creates operation based on the literal from the input
 */
public final class OperationFactory {

    private static final Pattern PATTERN = Pattern.compile("[A-Za-z]+ \\d+$");

    private OperationFactory() {
    }

    /**
     * Create operation based on the input. Input is in format <i>operation_symbol number</i>
     * Example inputs:
     * <ul>
     *     <li>add 5</li>
     *     <li>apply 7</li>
     * </ul>
     *
     */
    public static AbstractOperation createOperation(String operationString) {
        notEmpty(operationString, "operationString");

        if (!PATTERN.matcher(operationString).matches()) {
            throw new InvalidOperationStringException(
                format(
                    "Operation definition has to fulfill format [Operation Symbol][ ][Integer Value], but was '%s'",
                    operationString
                )
            );
        }

        final StringTokenizer stringTokenizer = new StringTokenizer(operationString);
        final String operationLiteral = stringTokenizer.nextToken();
        final String operationArgument = stringTokenizer.nextToken();

        return OperationTypes.fromLiteral(operationLiteral).createOperation(new BigDecimal(operationArgument));
    }
}
