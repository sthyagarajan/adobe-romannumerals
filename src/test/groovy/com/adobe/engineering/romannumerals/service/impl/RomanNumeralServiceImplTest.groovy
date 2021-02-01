package com.adobe.engineering.romannumerals.service.impl

import com.adobe.engineering.romannumerals.RomanNumeralApplication
import com.adobe.engineering.romannumerals.service.RomanNumeralService
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest(classes = RomanNumeralApplication.class)
class RomanNumeralServiceImplTest extends Specification{

    @Autowired
    private RomanNumeralService romanNumeralService;

    def expectedromannumeral;
    def inputnumeral;

    @Test
    def "Check if number is converted to numeral by service"(){
        given: "Number is converted to Roman Numeral using the service"
        expectedromannumeral = "CCXL"
        inputnumeral = 240

        when: "Romannumeral Service is called with given parameters we validate output"
        def actualromannumeral = romanNumeralService.getRomanNumeral(inputnumeral)
        println "Converted roman numeral for 240 is : "+ actualromannumeral.getRomanNumber()

        then: "We should see romannumeral as CCXL for input 240"
        actualromannumeral.getRomanNumber().equals(expectedromannumeral)

    }

}