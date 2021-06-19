package com.bhavesh.restpractice.newpractise;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.*;

@Configuration
@EnableSwagger2
public class SwagDocumentation {
    Contact contact=new Contact("Bhavesh","bhavesh.com","bhaveshzanzane@gmail.com");


    ApiInfo DEFAUL_API_INFO= new ApiInfo("BHAVESH_REST_API", "Passion", "0.0.1", "bhavesha.com", contact, "ApacheLicense", "License",new ArrayList<>());

    private static final Set<String> DEFAULT_PRODUCES= new HashSet<>(Arrays.asList("application/json","applicatin/xml"));
    private static final Set<String> DEFAULT_CONSUMES= new HashSet<>(Arrays.asList("application/json","applicatin/xml"));


    @Bean
    public Docket apiInfo() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("com.bhavesh.restpractice"))
                .build()
                .apiInfo(DEFAUL_API_INFO)
                .produces(DEFAULT_PRODUCES).consumes(DEFAULT_CONSUMES);
    }
}
