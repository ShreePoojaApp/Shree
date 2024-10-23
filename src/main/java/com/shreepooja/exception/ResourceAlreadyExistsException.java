package com.shreepooja.exception;

import org.springframework.stereotype.Component;

/**
 * The Resource Already Exists Exception class. This exception class needs to be
 * thrown when the required device is already exists in the application.
 */
@Component
public class ResourceAlreadyExistsException extends RuntimeException {
    /**
     * The default constructor.
     */
    public ResourceAlreadyExistsException() {
    }

    /**
     * Constructor to take exception message.
     *
     * @param message the exception message.
     */
    public ResourceAlreadyExistsException(final String message) {
        super(message);
    }
}
