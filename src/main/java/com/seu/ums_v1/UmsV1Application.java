package com.seu.ums_v1;

import com.seu.ums_v1.Entity.Role;
import com.seu.ums_v1.Entity.Superuser;
import com.seu.ums_v1.Entity.User;
import com.seu.ums_v1.Service.SuperuserService;
import com.seu.ums_v1.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class UmsV1Application {


    public static void main(String[] args) {
        SpringApplication.run(UmsV1Application.class, args);

    }

    @Bean
    public WebMvcConfigurer configure(){
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/v1/**")
                        .allowedMethods("*")
                        .allowedHeaders("*")
                        .allowedOrigins("*");
            }
        };
    }



}
