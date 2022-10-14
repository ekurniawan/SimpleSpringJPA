package com.rapidtech.springdatajpapgsql.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApi30Config {
    //http://localhost:8080/swagger-ui.html
    //http://localhost:8080/v3/api-docs

    private final String moduleName;
    private final String apiVersion;

    public OpenApi30Config(@Value("Spring Boot API") String moduleName,
                           @Value("1.0") String apiVersion){
        this.moduleName = moduleName;
        this.apiVersion = apiVersion;
    }
}
