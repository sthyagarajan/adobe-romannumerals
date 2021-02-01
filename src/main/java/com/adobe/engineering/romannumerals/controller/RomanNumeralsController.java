package com.adobe.engineering.romannumerals.controller;

import com.adobe.engineering.romannumerals.constants.RomanNumeralConstants;
import com.adobe.engineering.romannumerals.errors.Error;
import com.adobe.engineering.romannumerals.model.RomanNumeral;
import com.adobe.engineering.romannumerals.service.RomanNumeralService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * <h1>RomanNumeralsController</h1>
 * RomanNumeralsController acts as controller for the rest
 * microservices, all requests for the defined API will
 * go through this class
 * <p>
 * All requests for the defined API will go through this class
 * </p>
 *
 * @author  Sunder Thyagarajan
 * @version 1.0
 * @since   2021-01-30
 */

@RestController
@RequestMapping(value = RomanNumeralConstants.BASE_URI)
@CrossOrigin(origins = {"*"})
@Api(value= RomanNumeralConstants.BASE_URI, tags = {RomanNumeralConstants.API_TAG})
public class RomanNumeralsController {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RomanNumeralService romanNumeralService;

    /**
     * GET HTTP Request for converting a number into roman numeral
     * @param inputNumber QueryParam sent as part of request
     * @return ResponseEntity will be in RomanNumeral entity
     */
    @RequestMapping(value = "",params = RomanNumeralConstants.REQUEST_PARAM_NAME, method = RequestMethod.GET)
    @ApiOperation(value= RomanNumeralConstants.BASE_URI, notes = RomanNumeralConstants.NOTES, tags = {RomanNumeralConstants.API_TAG})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = RomanNumeralConstants.SUCCESSFUL_OPERATION, response = RomanNumeral.class),
            @ApiResponse(code = 400, message = RomanNumeralConstants.INVALID_REQUEST, response = Error.class),
            @ApiResponse(code = 405, message = RomanNumeralConstants.METHOD_NOT_ALLOWED, response = Error.class),
            @ApiResponse(code = 500, message = RomanNumeralConstants.INTERNAL_SERVER_ERROR),
    })
    public ResponseEntity<RomanNumeral> convertToRomanNumeral( @ApiParam(value = RomanNumeralConstants.REQUEST_PARAM_VALUE, allowableValues = RomanNumeralConstants.REQUEST_PARAM_ALLOWABLE_VALUES,required = true) @RequestParam(value = RomanNumeralConstants.REQUEST_PARAM_NAME) int inputNumber){
        if(LOGGER.isDebugEnabled()){
            LOGGER.debug("Converting number : " + inputNumber + " to roman numeral");
        }
        RomanNumeral romanNumeral = romanNumeralService.getRomanNumeral(inputNumber);
        return ResponseEntity.status(HttpStatus.OK).body(romanNumeral);
    }
}
