package com.adobe.engineering.romannumerals.service;

import com.adobe.engineering.romannumerals.model.RomanNumeral;
/**
 * <h1>RomanNumeralService</h1>
 * This is a interface for RomanNumeral conversion Service
 * <p>
 *  RomanNumeralService defines the contract for all
 *  the services that are leveraged to convert input
 *  number to roman numeral
 * </p>
 *
 * @author  Sunder Thyagarajan
 * @version 1.0
 * @since   2021-01-30
 */
public interface RomanNumeralService {
    RomanNumeral getRomanNumeral(int number);
}
