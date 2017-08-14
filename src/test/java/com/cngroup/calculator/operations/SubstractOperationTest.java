package com.cngroup.calculator.operations;

import org.junit.Test;

import java.math.BigDecimal;

public class SubstractOperationTest extends AbstractOperationTest {

    @Test
    public void testOperation() {
        testPerformOperation(new SubtractOperation(new BigDecimal(5)), new BigDecimal(25), new BigDecimal(20));
    }

}