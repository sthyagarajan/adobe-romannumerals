package com.adobe.engineering.romannumerals.util;
/**
 * <h1>ConversionUtils</h1>
 * ConversionUtils is a utility class to perform common tasks
 * <p>
 * ConversionUtils has desied utility methods as static
 * functions that can be called without instantiating the class
 * </p>
 *
 * @author  Sunder Thyagarajan
 * @version 1.0
 * @since   2021-01-30
 */
public class ConversionUtils {
    /**
     * This method loops through the supported units in descending order
     * and checks number of instances of each number and fetch corresponding
     * roman numeral. We will have a reference for anomalies too such as
     * 4, 40, 9, 90, e.t.c as that would help keep the logic simple
     * when checking for occurences
     *
     * @param num Number to convert to romanNumeral
     * @param units Units supported for given strategy
     * @param romanunits Roman Units supported for given strategy
     * @return
     */
    public static String convertToRomanNumeral(int num, int[] units, String[] romanunits){
        StringBuilder romanNumber = new StringBuilder();
        int instances;
        for(int i=units.length-1; i>=0; i--){
            instances = num/units[i];
            for(int j=0; j<instances; j++){
                romanNumber.append(romanunits[i]);
            }
            num = num - units[i] * instances;
        }
        return romanNumber.toString();
    }
}
