package com.shreepooja.exception;

import org.springframework.stereotype.Component;

/**
 * The Resource Not Found Exception class. This exception class needs to be
 * thrown when the required resource is not found in the application.
 */
@Component
public class ResourceNotFoundException extends RuntimeException {
    /**
     * The default constructor.
     */
    public ResourceNotFoundException() {
    }

    /**
     * Constructor to take exception message.
     *
     * @param message the exception message.
     */
    public ResourceNotFoundException(final String message) {
        super(message);
    }
}
