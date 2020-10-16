package com.kitten.kittenws.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.stream.IntStream;

@Configuration
@EnableWebMvc
public class WebConfiguration implements WebMvcConfigurer {

    private static final String PREFIX = "file:./";
    private static final String[] MAPPINGS = {"/img/**", "/css/**", "/js/**"};
    private static final String[] LOCATIONS = {"uploaded/img/", "/uploaded/css/", "/uploaded/js/"};

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        IntStream.range(0, MAPPINGS.length)
                .forEach(idx -> registry.addResourceHandler(MAPPINGS[idx])
                .addResourceLocations(PREFIX+LOCATIONS[idx]));
    }
}
