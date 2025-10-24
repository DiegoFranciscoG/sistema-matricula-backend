package com.ista.springboot.web.app.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("API Sistema de Matricula - TecAzuay")
                .version("1.0.0")
                .description("API REST para gestion de matriculas estudiantiles del Instituto Tecnologico del Azuay")
                .contact(new Contact()
                    .name("TecAzuay")
                    .email("soporte@tecazuay.edu.ec")));
    }
}