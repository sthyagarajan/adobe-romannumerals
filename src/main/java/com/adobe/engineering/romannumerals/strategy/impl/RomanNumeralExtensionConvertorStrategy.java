package com.adobe.engineering.romannumerals.strategy.impl;

import com.adobe.engineering.romannumerals.errors.Error;
import com.adobe.engineering.romannumerals.exception.ServiceException;
import com.adobe.engineering.romannumerals.strategy.RomanNumeralConvertorStrategy;
import com.adobe.engineering.romannumerals.util.ConversionUtils;


/**
 * <h1>RomanNumeralExtensionConvertorStrategy</h1>
 * This is a class for supporting extension feature
 * <p>
 *  RomanNumeralExtensionConvertorStrategy supports conversion
 *  of roman numerals 1-3999
 * </p>
 *
 * @author  Sunder Thyagarajan
 * @version 1.0
 * @since   2021-01-30
 */

public class RomanNumeralExtensionConvertorStrategy implements RomanNumeralConvertorStrategy {
    static int[] units = {1,4,5,9,10,40,50,90,100,400,500,900,1000};
    static String[] romanunits = {"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};

    @Override
    public String convertToRomanNumeral(int number) {
        if(number>3999 || number < 1){
            throw new ServiceException(Error.INVALID_INPUT_EXTENDED);
        }
        return ConversionUtils.convertToRomanNumeral(number, units, romanunits);
    }
}
