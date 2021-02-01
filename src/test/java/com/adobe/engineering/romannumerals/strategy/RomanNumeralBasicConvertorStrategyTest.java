package com.adobe.engineering.romannumerals.strategy;

import com.adobe.engineering.romannumerals.exception.ServiceException;
import com.adobe.engineering.romannumerals.strategy.impl.RomanNumeralBasicConvertorStrategy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RomanNumeralBasicConvertorStrategyTest {

    private RomanNumeralConvertorStrategy romanNumeralConvertorStrategy;

    @BeforeEach
    void setUp() {
        romanNumeralConvertorStrategy = new RomanNumeralBasicConvertorStrategy();
    }

    @Test
    @DisplayName("Test SingleDigit Simple use cases")
    void testSingleDigitSimpleConversions(){
        assertEquals("I",romanNumeralConvertorStrategy.convertToRomanNumeral(1), "Validate conversion of number one");
        assertEquals("II",romanNumeralConvertorStrategy.convertToRomanNumeral(2), "Validate conversion of number two");
        assertEquals("V",romanNumeralConvertorStrategy.convertToRomanNumeral(5), "Validate conversion of number five");
        assertEquals("VII",romanNumeralConvertorStrategy.convertToRomanNumeral(7), "Validate conversion of number seven");
    }

    @Test
    @DisplayName("Test DoubleDigit Simple use cases")
    void testDoubleDigitSimpleConversions(){
        assertEquals("X",romanNumeralConvertorStrategy.convertToRomanNumeral(10), "Validate conversion of number ten");
        assertEquals("XI",romanNumeralConvertorStrategy.convertToRomanNumeral(11), "Validate conversion of number eleven");
        assertEquals("XXIV",romanNumeralConvertorStrategy.convertToRomanNumeral(24), "Validate conversion of number twenty four");
        assertEquals("XXXVII",romanNumeralConvertorStrategy.convertToRomanNumeral(37), "Validate conversion of number thirty seven");
        assertEquals("LXI",romanNumeralConvertorStrategy.convertToRomanNumeral(61), "Validate conversion of number thirty seven");
        assertEquals("LIX",romanNumeralConvertorStrategy.convertToRomanNumeral(59), "Validate conversion of number thirty seven");
    }

    @Test
    @DisplayName("Test DoubleDigit Complex use cases")
    void testDoubleDigitComplexConversions(){
        assertEquals("XL",romanNumeralConvertorStrategy.convertToRomanNumeral(40), "Validate conversion of number forty");
        assertEquals("XLVII",romanNumeralConvertorStrategy.convertToRomanNumeral(47), "Validate conversion of number forty seven");
        assertEquals("XCIV",romanNumeralConvertorStrategy.convertToRomanNumeral(94), "Validate conversion of number ninety four");
    }

    @Test
    @DisplayName("Test TripleDigit Simple use cases")
    void testTripleDigitSimpleConversions(){
        assertEquals("C",romanNumeralConvertorStrategy.convertToRomanNumeral(100), "Validate conversion of number hundred");
        assertEquals("CC",romanNumeralConvertorStrategy.convertToRomanNumeral(200), "Validate conversion of number two hundred");
        assertEquals("CXXIV",romanNumeralConvertorStrategy.convertToRomanNumeral(124), "Validate conversion of number one hundred twenty four");
        assertEquals("CCLV",romanNumeralConvertorStrategy.convertToRomanNumeral(255), "Validate conversion of number two hundred fifty five");

    }

    @Test
    @DisplayName("Test Negative Boundary Conditions")
    void testNegativeBoundaryConditions(){
        // Should have thrown ServiceException
       assertThrows(ServiceException.class,() -> romanNumeralConvertorStrategy.convertToRomanNumeral(256), "Validate outside boundary runtime exceptions with number 256");
       assertThrows(ServiceException.class,() -> romanNumeralConvertorStrategy.convertToRomanNumeral(0), "Validate outside boundary runtime exceptions with number 0");
    }

}