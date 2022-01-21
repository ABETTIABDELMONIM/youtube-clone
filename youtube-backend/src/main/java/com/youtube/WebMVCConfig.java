package com.youtube;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMVCConfig implements WebMvcConfigurer{

    @Override
    public void addCorsMappings(CorsRegistry corsRegistry){
        corsRegistry.addMapping("/**")
        .allowedOrigins("*")
        .allowedMethods("GET","POST","PUT")
        .allowedHeaders("*")
        .maxAge(3600);
    }
    
}
