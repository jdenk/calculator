package com.cngroup.calculator.cli;

import com.cngroup.calculator.service.CalculatorService;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

@Component
@ConditionalOnProperty(value = "mode", havingValue = "cli")
public class CalculatorCLI implements CommandLineRunner {

    private final CalculatorService calculatorService;

    @Option(name = "-f", aliases = "--file",  required = true, usage = "Input File - full path to the input file (required)")
    private String filePath;

    public CalculatorCLI(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @Override
    public void run(String... args) throws IOException {
        CmdLineParser parser = new CmdLineParser(this);
        try {
            parser.parseArgument(args);
            System.out.println("\nResult of calculation is: " + calculatorService.calculate(new File(filePath)));
        } catch (CmdLineException e) {
            System.err.println(e.getMessage());
            parser.printUsage(System.err);
        } catch (Exception e) {
            System.err.println("\nFailed to calculate the result based on given file. See the error below:");
            System.err.println("------------------------------------------------------------------------");
            e.printStackTrace();
        }
    }
}

