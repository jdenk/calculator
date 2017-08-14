package com.cngroup.calculator.service;

import com.cngroup.calculator.operations.AbstractOperation;
import com.cngroup.calculator.operations.exception.InputNotReadableException;
import com.cngroup.calculator.operations.exception.OperationExecutionException;
import com.cngroup.calculator.operations.factory.OperationFactory;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Stream;

import static com.cngroup.calculator.operations.factory.OperationTypes.APPLY;
import static com.google.common.collect.Iterables.getLast;
import static com.google.common.collect.Iterables.isEmpty;
import static java.lang.String.format;
import static java.util.stream.Collectors.toList;

/**
 * Calculator logic implementation.
 * Takes input file containing the operations sequence and returns the result
 */
@Component
public class CalculatorService {

    /**
     * Performs calculator logic, returns calculation result
     *
     * @param inputFile points to the existing file on the FS, containing the operations sequence
     */
    public BigDecimal calculate(File inputFile) {
        try (final Stream<String> stringStream = Files.lines(inputFile.toPath())) {

            final List<AbstractOperation> operationList = stringStream.map(OperationFactory::createOperation).collect(toList());

            validate(operationList);

            return doCalculate(operationList);

        } catch(IOException e) {
            throw new InputNotReadableException(format("Given input file %s cannot be read", inputFile), e);
        }
    }

    private void validate(List<AbstractOperation> operationList) {
        if(isEmpty(operationList)) {
            throw new OperationExecutionException("Input is empty. There should be at least some operations");
        }

        final AbstractOperation lastOperation = getLast(operationList);

        if(lastOperation.getOperationType() != APPLY) {
            throw new OperationExecutionException(format("Last operation in the list must be '%s' operation", APPLY.getLiteral()));
        }

        final List<AbstractOperation> applyOps = operationList.stream().filter(op -> op.getOperationType() == APPLY).collect(toList());
        if(applyOps.size() > 1) {
            throw new OperationExecutionException(format("There should be only one '%s' operation", APPLY.getLiteral()));
        }
    }

    private BigDecimal doCalculate(List<AbstractOperation> operationList) {
        return operationList.stream().reduce(
            getLast(operationList).getArgument(),
            (input, operation) -> operation.perform(input),
            (previousResult, thisResult) -> thisResult
        );
    }

}
