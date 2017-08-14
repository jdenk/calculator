package com.cngroup.calculator.operations.exception;

public class InvalidOperationStringException extends RuntimeException {

    public InvalidOperationStringException(String message) {
        super(message);
    }

    public InvalidOperationStringException(String message, Throwable cause) {
        super(message, cause);
    }
}
