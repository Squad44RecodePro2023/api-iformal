package com.iformal.iformal.configuration;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Swagger3Configuration
 */
@Configuration
public class Swagger3Config {
    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
        .group("iformal")
        .pathsToMatch("/api/**")
        .build();
    }

    
}