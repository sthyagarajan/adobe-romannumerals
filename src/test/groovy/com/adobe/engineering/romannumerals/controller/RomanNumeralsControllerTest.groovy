package com.adobe.engineering.romannumerals.controller

import com.adobe.engineering.romannumerals.RomanNumeralApplication
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.HttpStatus
import spock.lang.Specification

@SpringBootTest(classes = RomanNumeralApplication.class)
class RomanNumeralsControllerTest extends Specification {

    @Autowired(required = false)
    private RomanNumeralsController romanNumeralsController;

    def expectedromannumeral;
    def inputnumeral;


    @Test
    def "when context is loaded then all expected beans are created"() {
        expect: "the RomanNumeralsController is created"
        romanNumeralsController
    }

    @Test
    def "when controller is called with valid romannumeral"() {
        given: "Number is converted to Roman Numeral using the controller"
        expectedromannumeral = "CCXL"
        inputnumeral = 240

        when: "Romannumeral controller is called with given parameters we validate output"
        def actualresponseentity = romanNumeralsController.convertToRomanNumeral(inputnumeral)
        println "Converted roman numeral for 240 is : "+ actualresponseentity

        then: "the RomanNumeralsController responds with right RomanNumeral"
        actualresponseentity.statusCode.equals(HttpStatus.OK)
        actualresponseentity.body.getRomanNumber().equals(expectedromannumeral)
    }
}
