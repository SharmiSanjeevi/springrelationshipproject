package com.gamestore.exceptions;

public class RequirementNotFoundException extends RuntimeException {
    public RequirementNotFoundException() {
    }

    public RequirementNotFoundException(String message) {
        super(message);
    }
}
