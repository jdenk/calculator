package com.cngroup.calculator.operations;

import com.cngroup.calculator.operations.exception.OperationExecutionException;
import org.junit.Test;

import java.math.BigDecimal;

import static java.math.BigDecimal.ZERO;

public class DivideOperationTest extends AbstractOperationTest {

    @Test
    public void testOperation() {
        testPerformOperation(new DivideOperation(new BigDecimal(5)), new BigDecimal(25), new BigDecimal(5));
    }

    @Test(expected = OperationExecutionException.class)
    public void testOperationDivisionByZero() {
        testPerformOperation(new DivideOperation(ZERO), new BigDecimal(5), new BigDecimal(5));
    }


}