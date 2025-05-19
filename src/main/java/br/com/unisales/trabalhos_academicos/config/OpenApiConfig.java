package br.com.unisales.trabalhos_academicos.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("API de Trabalhos Acadêmicos")
                .version("1.0")
                .description("API para gerenciar trabalhos da faculdade (CRUD)"));
    }
}
