package com.adobe.engineering.romannumerals


import com.adobe.engineering.romannumerals.constants.RomanNumeralConstants
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import spock.lang.Specification

@AutoConfigureMockMvc
@SpringBootTest(classes = RomanNumeralApplication.class)
@Tag("integrationTest")
class RomanNumeralApplicationIntegrationTests extends Specification  {

    @Autowired
    MockMvc mvc;

    @Test
    public void integrationTestValidRomanNumeral() throws Exception
    {
        mvc.perform( MockMvcRequestBuilders
                .get(RomanNumeralConstants.BASE_URI)
                .param(RomanNumeralConstants.REQUEST_PARAM_NAME,"201")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath(".romanNumber").exists())
                .andExpect(MockMvcResultMatchers.jsonPath(".romanNumber").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath(".romanNumber").value("CCI"));
    }


    @Test
    public void integrationTestMethodNotAllowed() throws Exception
    {
        mvc.perform( MockMvcRequestBuilders
                .post(RomanNumeralConstants.BASE_URI)
                .param(RomanNumeralConstants.REQUEST_PARAM_NAME,"201")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isMethodNotAllowed());
    }

    @Test
    public void integrationTestInvalidAlphaNumericInput() throws Exception
    {
        mvc.perform( MockMvcRequestBuilders
                .get(RomanNumeralConstants.BASE_URI)
                .param(RomanNumeralConstants.REQUEST_PARAM_NAME,"ABC")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath(".errorCode").value("102"))
                .andExpect(MockMvcResultMatchers.jsonPath(".errorDescription").value("Please provide numbers only as input"))
    }

    @Test
    public void integrationTestInvalidNumberOutsideRange() throws Exception
    {
        mvc.perform( MockMvcRequestBuilders
                .get(RomanNumeralConstants.BASE_URI)
                .param(RomanNumeralConstants.REQUEST_PARAM_NAME,"5000")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath(".errorCode").value("101"))
                .andExpect(MockMvcResultMatchers.jsonPath(".errorDescription").value("Please provide input number between 1 and 3999"))
    }
}
