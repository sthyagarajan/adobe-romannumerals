package com.adobe.engineering.romannumerals;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * <h1>RomanNumeralApplication</h1>
 * SpringBoot Application
 * <p>Main spring bootup class for triggering the whole application.</p>
 *
 * @author  Sunder Thyagarajan
 * @version 1.0
 * @since   2021-01-30
 */
@SpringBootApplication(scanBasePackages = {"com.adobe.engineering.romannumerals.controller"})
@ComponentScan
public class RomanNumeralApplication {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(RomanNumeralApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }
}
