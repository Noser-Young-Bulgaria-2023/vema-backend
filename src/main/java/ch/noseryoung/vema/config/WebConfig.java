package ch.noseryoung.vema.config;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig {

    @Value("${vema.application.frontend.origin}")
    private String frontendOrigin;


    @Bean
    public WebMvcConfigurer corsConfigurer() {
        System.out.println("Allowed origin: " + frontendOrigin);
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins(frontendOrigin);
            }
        };
    }
}
