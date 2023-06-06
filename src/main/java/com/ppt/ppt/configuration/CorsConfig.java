package com.ppt.ppt.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOriginPatterns("*") // Permitir todas las URL de origen
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Permitir los métodos HTTP
                .allowedHeaders("*") // Permitir todas las cabeceras
                .allowCredentials(true) // Permitir enviar credenciales (cookies, encabezados de autenticación, etc.)
                .maxAge(3600); // Configurar el tiempo máximo de almacenamiento en caché de las opciones pre-vuelo (preflight)
    }
}

