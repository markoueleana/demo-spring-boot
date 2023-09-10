package com.luv2code.springboot.cruddemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class DemoSecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {

        UserDetails giannis = User.builder()
                .username("Giannis")
                .password("test123")
                .roles("ADMIN")
                .build();

        UserDetails billy = User.builder()
                .username("Billy")
                .password("test123")
                .roles("EMPLOYEE,MANGER")
                .build();

        UserDetails tasos = User.builder()
                .username("Tasos")
                .password("test123")
                .roles("EMPLOYEE,MANGER,ADMIN")
                .build();
        return new InMemoryUserDetailsManager(giannis, billy, tasos);
    }

}
