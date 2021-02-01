package com.adobe.engineering.romannumerals.swagger;

import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * <h1>SwaggerConfig</h1>
 * Swagger documentation class used for defining swagger API.
 *
 * @author  Sunder Thyagarajan
 * @version 1.0
 * @since   2021-01-30
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket postsApi() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("public-api")
                .apiInfo(apiInfo()).select().paths(postPaths()).build();
    }

    private Predicate<String> postPaths() {
        return PathSelectors.regex("/api.*");
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("RomanNumerals conversion API")
                .description("RomanNumerals conversion API reference for developers")
                .contact("sunder.thyagarajan@gmail.com").license("Sunder Thyagarajan License")
                .licenseUrl("sunder.thyagarajan@gmail.com").version("1.0").build();
    }


}

