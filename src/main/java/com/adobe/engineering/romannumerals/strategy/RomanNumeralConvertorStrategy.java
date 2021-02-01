package com.adobe.engineering.romannumerals.strategy;

/**
 * <h1>RomanNumeralConvertorStrategy</h1>
 * This is a interface for RomanNumeralConvertorStrategy
 * <p>
 *  RomanNumeralConvertorStrategy leverages startegy design pattern
 *  to define the rules for converting roman numerals
 *  including supported values
 * </p>
 *
 * @author  Sunder Thyagarajan
 * @version 1.0
 * @since   2021-01-30
 */
public interface RomanNumeralConvertorStrategy {
    public String convertToRomanNumeral(int number);
}
