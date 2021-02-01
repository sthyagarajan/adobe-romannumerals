package com.adobe.engineering.romannumerals.strategy.impl;

import com.adobe.engineering.romannumerals.errors.Error;
import com.adobe.engineering.romannumerals.exception.ServiceException;
import com.adobe.engineering.romannumerals.strategy.RomanNumeralConvertorStrategy;
import com.adobe.engineering.romannumerals.util.ConversionUtils;

/**
 * <h1>RomanNumeralBasicConvertorStrategy</h1>
 * This is a class for supporting basic feature
 * <p>
 *  RomanNumeralBasicConvertorStrategy supports conversion
 *  of roman numerals 1-255
 * </p>
 *
 * @author  Sunder Thyagarajan
 * @version 1.0
 * @since   2021-01-30
 */

public class RomanNumeralBasicConvertorStrategy implements RomanNumeralConvertorStrategy {

    static int[] units = {1,4,5,9,10,40,50,90,100};
    static String[] romanunits = {"I","IV","V","IX","X","XL","L","XC","C"};

    @Override
    public String convertToRomanNumeral(int number) {
        if(number>255 || number < 1){
            throw new ServiceException(Error.INVALID_INPUT_BASIC);
        }
        return ConversionUtils.convertToRomanNumeral(number, units, romanunits);
    }
}
