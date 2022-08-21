package com.example.etorobackend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration

public class PasswordConfig {
@Bean
    public BCryptPasswordEncoder passwordEncoder(){
    return (BCryptPasswordEncoder) NoOpPasswordEncoder.getInstance();
}
}
