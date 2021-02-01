package com.adobe.engineering.romannumerals.constants;

/**
 * <h1>RomanNumeralConstants</h1>
 * Define the constants used for the application
 *
 * @author  Sunder Thyagarajan
 * @version 1.0
 * @since   2021-01-30
 */

public interface RomanNumeralConstants {
    String NOTES = "The API supports conversion of decimal numbers to roman numerals within the prescribed range";
    String API_NAME = "convertToRomanNumeral";
    String API_VALUE = "Convert to Romannumeral";
    String API_TAG = "Number System Conversion Utils";
    String REQUEST_PARAM_VALUE = "Input number to be converted to RomanNumeral";
    String REQUEST_PARAM_ALLOWABLE_VALUES = "1-3999";

    //API RESPONSE MESSAGES BASED ON HTTP CODE
    String SUCCESSFUL_OPERATION = "OK.";//200
    String INVALID_REQUEST = "Bad request.";//400
    String INTERNAL_SERVER_ERROR = "Internal server error.";//500

    //Error Messages
    String VALID_INPUT_BASIC_DESCRIPTION = "Please provide input number between 1 and 255";
    String VALID_INPUT_EXTENDED_DESCRIPTION = "Please provide input number between 1 and 3999";
    String INVALID_INPUT_NON_NUMERIC = "Please provide numbers only as input";
    String REQUIRED_FIELD_MISSING = "Mandatory paramerer query missing";
    String METHOD_NOT_ALLOWED = "Please use only HTTP GET request as request method";

    String BASE_URI = "/api/v1/romannumeral";
    String REQUEST_PARAM_NAME = "query";
}
