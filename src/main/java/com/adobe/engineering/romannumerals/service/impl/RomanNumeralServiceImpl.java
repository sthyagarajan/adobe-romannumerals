package com.adobe.engineering.romannumerals.service.impl;

import com.adobe.engineering.romannumerals.model.RomanNumeral;
import com.adobe.engineering.romannumerals.service.RomanNumeralService;
import com.adobe.engineering.romannumerals.strategy.RomanNumeralConvertorStrategy;
import com.adobe.engineering.romannumerals.strategy.impl.RomanNumeralExtensionConvertorStrategy;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * <h1>RomanNumeralServiceImpl</h1>
 * This is service class that converts integers to romannumerals
 * <p>
 *  RomanNumeralService has the desired converter strategy
 *  injected into it, it has necessary functions that can
 *  help controller API converts numerals
 * </p>
 *
 * @author  Sunder Thyagarajan
 * @version 1.0
 * @since   2021-01-30
 */

@Service
public class RomanNumeralServiceImpl implements RomanNumeralService {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    RomanNumeralConvertorStrategy romanNumeralConvertorStrategy = new RomanNumeralExtensionConvertorStrategy();

    /**
     * This is a service method that is responsible for converting
     * inputnumber to romannumber leveraging the converter strategy
     * @param number
     * @return
     */
    @Override
    public RomanNumeral getRomanNumeral(int number) {
        long starttime = System.currentTimeMillis();
        if(LOGGER.isTraceEnabled()){
            LOGGER.trace("Start of service method getRomanNumeral with input : " + number);
        }
        String romanNumber = romanNumeralConvertorStrategy.convertToRomanNumeral(number);
        RomanNumeral romanNumeral = new RomanNumeral();
        romanNumeral.setRomanNumber(romanNumber);
        if(LOGGER.isTraceEnabled()){
            LOGGER.trace("End of service method getRomanNumeral with converted romanumeral : " + romanNumeral.getRomanNumber());
        }
        if(LOGGER.isDebugEnabled()){
            LOGGER.debug("Time taken to execute getRomanNumeral : " + (System.currentTimeMillis()-starttime));
        }
        return romanNumeral;
    }
}
