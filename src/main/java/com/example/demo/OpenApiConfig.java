package com.example.demo;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI openAPI() {
        Info info = new Info().version("0.0.1").title("SpringBoot Demo").description("API Description");

        String jwtSchemeName = "basicAuth";
        SecurityRequirement securityRequirement = new SecurityRequirement().addList(jwtSchemeName);
        Components components = new Components()
                .addSecuritySchemes(jwtSchemeName, new SecurityScheme()
                        .name(jwtSchemeName)
                        .type(SecurityScheme.Type.HTTP) // HTTP 방식
                        .scheme("basic")
                        .bearerFormat("JWT"));

        return new OpenAPI().info(info)
                .addSecurityItem(securityRequirement)
                .components(components);
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
