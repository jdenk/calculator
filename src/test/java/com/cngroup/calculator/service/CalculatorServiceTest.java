package com.cngroup.calculator.service;

import com.cngroup.calculator.operations.exception.InputNotReadableException;
import com.cngroup.calculator.operations.exception.InvalidOperationStringException;
import com.cngroup.calculator.operations.exception.OperationExecutionException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.springframework.util.ResourceUtils.getFile;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CalculatorServiceTest {

    @Autowired
    private CalculatorService calculatorService;

    @Test
    public void testCalculate1() throws FileNotFoundException {

        final BigDecimal result = calculatorService.calculate(getFile("classpath:inputs/test_input_1.txt"));

        assertThat(result.compareTo(new BigDecimal(18)), is(0));
    }

    @Test
    public void testCalculate2() throws FileNotFoundException {
        final BigDecimal result = calculatorService.calculate(getFile("classpath:inputs/test_input_2.txt"));

        assertThat(result.compareTo(new BigDecimal(45)), is(0));
    }

    @Test
    public void testCalculate3() throws FileNotFoundException {
        final BigDecimal result = calculatorService.calculate(getFile("classpath:inputs/test_input_3.txt"));

        assertThat(result.compareTo(new BigDecimal(25)), is(0));
    }

    @Test
    public void testCalculateOnlyApply() throws FileNotFoundException {
        final BigDecimal result = calculatorService.calculate(getFile("classpath:inputs/test_input_only_apply.txt"));

        assertThat(result.compareTo(new BigDecimal(4)), is(0));
    }


    @Test(expected = InvalidOperationStringException.class)
    public void testCalculateMissingNumberOnInput() throws FileNotFoundException {
        calculatorService.calculate(getFile("classpath:inputs/malformed_missing_number.txt"));
    }


    @Test(expected = InputNotReadableException.class)
    public void testInvalidInputFile() throws FileNotFoundException {
        calculatorService.calculate(new File("nonsense12031423"));
    }

    @Test(expected = InvalidOperationStringException.class)
    public void testCalculateInvalidOperation() throws FileNotFoundException {
        calculatorService.calculate(getFile("classpath:inputs/malformed_invalid_operation.txt"));
    }

    @Test(expected = OperationExecutionException.class)
    public void testCalculateMissingApply() throws FileNotFoundException {
        calculatorService.calculate(getFile("classpath:inputs/malformed_missing_apply.txt"));
    }

    @Test(expected = OperationExecutionException.class)
    public void testCalculateMoreThanOneApply() throws FileNotFoundException {
        calculatorService.calculate(getFile("classpath:inputs/malformed_more_than_one_apply.txt"));
    }

    @Test(expected = OperationExecutionException.class)
    public void testCalculateEmptyInput() throws FileNotFoundException {
        calculatorService.calculate(getFile("classpath:inputs/malformed_empty_input.txt"));
    }

}