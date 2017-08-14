package com.cngroup.calculator.operations;

import org.junit.Test;

import java.math.BigDecimal;

public class AdditionOperationTest extends AbstractOperationTest {

    @Test
    public void testOperation() {
        testPerformOperation(new AdditionOperation(new BigDecimal(25)), new BigDecimal(8), new BigDecimal(33));
    }

}