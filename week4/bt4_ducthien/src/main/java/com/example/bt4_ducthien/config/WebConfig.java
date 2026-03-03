package com.example.bt4_ducthien.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.file.Path;
import java.nio.file.Paths;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    public static final Path UPLOAD_IMAGES_DIR = Paths.get("uploads/images").toAbsolutePath();

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/images/**")
                .addResourceLocations("file:" + UPLOAD_IMAGES_DIR + "/", "classpath:/static/images/");
    }
}
    