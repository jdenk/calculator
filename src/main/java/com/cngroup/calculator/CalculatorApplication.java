package com.cngroup.calculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class CalculatorApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(CalculatorApplication.class, args);
	}
}
