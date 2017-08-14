package com.cngroup.calculator.operations;

import java.math.BigDecimal;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


public class AbstractOperationTest {

    void testPerformOperation(AbstractOperation abstractBinaryOperation, BigDecimal input, BigDecimal expectedVal) {
        final BigDecimal result = abstractBinaryOperation.perform(input);
        assertThat(result.compareTo(expectedVal), is(0));

    }
}
