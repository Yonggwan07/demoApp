package com.example.demo;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI openAPI() {
        Info info = new Info().version("0.0.1").title("SpringBoot Demo").description("API Description");
        return new OpenAPI().info(info);
    }

    @Bean
    public GroupedOpenApi all() {
        return GroupedOpenApi.builder().group("All").pathsToMatch("/api/**").build();
    }

    @Bean
    public GroupedOpenApi tmm() {
        return GroupedOpenApi.builder().group("공통관리").pathsToMatch("/api/TMM*/**").build();
    }
}
