package com.example.equipoFutbol.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API equipo futbol")
                        .version("1.0")
                        .description("Documentación de la API para gestionar BD en Supabase")
                        .contact(new Contact()
                                .name("Soporte API")
                                .email("sazamora@ucundinamarca.edu.co")));
    }
}

