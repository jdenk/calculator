package com.cngroup.calculator.operations;

import org.junit.Test;

import java.math.BigDecimal;

public class MultiplyOperationTest extends AbstractOperationTest {

    @Test
    public void testOperation() {
        testPerformOperation(new MultiplyOperation(new BigDecimal(5)), new BigDecimal(25), new BigDecimal(125));
    }

}