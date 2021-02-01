package com.adobe.engineering.romannumerals.errors;

import com.adobe.engineering.romannumerals.constants.RomanNumeralConstants;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.http.HttpStatus;

/**
 * <h1>Error</h1>
 * Error is a enum that stores all Error Codes
 *
 * <p>
 * Error is a enum that tackles all possible HTTP errors for the request API
 * </p>
 *
 * @author  Sunder Thyagarajan
 * @version 1.0
 * @since   2021-01-30
 */

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Error {
    INVALID_INPUT_BASIC("100","Bad Request", RomanNumeralConstants.VALID_INPUT_BASIC_DESCRIPTION, HttpStatus.BAD_REQUEST.value()),
    INVALID_INPUT_EXTENDED("101","Bad Request", RomanNumeralConstants.VALID_INPUT_EXTENDED_DESCRIPTION,  HttpStatus.BAD_REQUEST.value()),
    INVALID_INPUT_NON_NUMERIC("102","Bad Request", RomanNumeralConstants.INVALID_INPUT_NON_NUMERIC, HttpStatus.BAD_REQUEST.value()),
    REQUIRED_FIELD_MISSING("103","Bad Request", RomanNumeralConstants.REQUIRED_FIELD_MISSING, HttpStatus.BAD_REQUEST.value()),
    METHOD_NOT_ALLOWED("104","Unsupported Method", RomanNumeralConstants.METHOD_NOT_ALLOWED,  HttpStatus.METHOD_NOT_ALLOWED.value());

    String errorCode;
    String errorMessage;
    String errorDescription;
    int httpResponseCode;

    public int getHttpResponseCode() {
        return httpResponseCode;
    }

    public void setHttpResponseCode(int httpResponseCode) {
        this.httpResponseCode = httpResponseCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }

    Error(String errorCode, String errorMessage, String errorDescription, int httpResponseCode) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.errorDescription = errorDescription;
        this.httpResponseCode = httpResponseCode;
    }


}
