package com.bishnu.portfolio;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudinary.Cloudinary;

@Configuration
public class CloudinaryConfig {

    @Bean
    public Cloudinary cloudinary() {
        Map<String, String> config = new HashMap<>();
        config.put("cloud_name", "du1tbr8ro");
        config.put("api_key", "353671544956378");
        config.put("api_secret", "1lXc4lGrcZ3S-93Z9wm2R0G21w4");

        return new Cloudinary(config);
    }
}