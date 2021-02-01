package com.adobe.engineering.romannumerals.exception;

import com.adobe.engineering.romannumerals.errors.Error;

/**
 * <h1>ServiceException</h1>
 * ServiceException is a runtime exception
 * <p>
 * ServiceException is a runtime exception that super class
 * for all custom exceptions thrown by SpringBoot application
 * </p>
 *
 * @author  Sunder Thyagarajan
 * @version 1.0
 * @since   2021-01-30
 */

public class ServiceException extends RuntimeException {
    public Error getError() {
        return error;
    }

    private Error error;

    public ServiceException(Error error) {
        super();
        this.error = error;
    }
}
