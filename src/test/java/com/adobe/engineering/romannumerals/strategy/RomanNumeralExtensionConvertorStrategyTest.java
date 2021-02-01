package com.adobe.engineering.romannumerals.strategy;

import com.adobe.engineering.romannumerals.exception.ServiceException;
import com.adobe.engineering.romannumerals.strategy.impl.RomanNumeralBasicConvertorStrategy;
import com.adobe.engineering.romannumerals.strategy.impl.RomanNumeralExtensionConvertorStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RomanNumeralExtensionConvertorStrategyTest {

    private RomanNumeralConvertorStrategy romanNumeralConvertorStrategy;

    @BeforeEach
    void setUp() {
        romanNumeralConvertorStrategy = new RomanNumeralExtensionConvertorStrategy();
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
        assertEquals("D",romanNumeralConvertorStrategy.convertToRomanNumeral(500), "Validate conversion of number five hundred");
        assertEquals("DCCLVII",romanNumeralConvertorStrategy.convertToRomanNumeral(757), "Validate conversion of number seven hundred fifty seven");

    }


    @Test
    @DisplayName("Test TripleDigit Complex use cases")
    void testTripleDigitComplexConversions(){
        assertEquals("CD",romanNumeralConvertorStrategy.convertToRomanNumeral(400), "Validate conversion of number hundred");
        assertEquals("CM",romanNumeralConvertorStrategy.convertToRomanNumeral(900), "Validate conversion of number nine hundred");
        assertEquals("CMXCIX",romanNumeralConvertorStrategy.convertToRomanNumeral(999), "Validate conversion of number one hundred twenty four");
    }

    @Test
    @DisplayName("Test FourDigit Simple use cases")
    void testFourDigitSimpleConversions(){
        assertEquals("M",romanNumeralConvertorStrategy.convertToRomanNumeral(1000), "Validate conversion of number thousand");
        assertEquals("MDXCIX",romanNumeralConvertorStrategy.convertToRomanNumeral(1599), "Validate conversion of number thousand five hundred ninety nine");
        assertEquals("MMCC",romanNumeralConvertorStrategy.convertToRomanNumeral(2200), "Validate conversion of number two thousand two hundred");
        assertEquals("MMMCMXCIX",romanNumeralConvertorStrategy.convertToRomanNumeral(3999), "Validate conversion of number three thousand three hundred ninety nine");
    }


    @Test
    @DisplayName("Test Negative Boundary Conditions")
    void testNegativeBoundaryConditions(){
        // Should have thrown ServiceException
       assertThrows(ServiceException.class,() -> romanNumeralConvertorStrategy.convertToRomanNumeral(4000), "Validate outside boundary runtime exceptions with number 4000");
       assertThrows(ServiceException.class,() -> romanNumeralConvertorStrategy.convertToRomanNumeral(0), "Validate outside boundary runtime exceptions with number 0");
    }

}