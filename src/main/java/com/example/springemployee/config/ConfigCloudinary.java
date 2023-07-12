package com.example.springemployee.config;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigCloudinary {
    @Bean
    public Cloudinary cloudinaryConfig() {
        Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name","dks1oreg8",
                "api_key","537757986968683",
                "api_secret","QthBxnqcdMYt6m2gIEh0rWww1Qk"
        ));
        return cloudinary;
    }
}
