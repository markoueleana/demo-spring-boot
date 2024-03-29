package com.springboot.demosecurity.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig {
        @Bean
        public UserDetailsManager userDetailsManager(DataSource dataSource){
            JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
            jdbcUserDetailsManager.setUsersByUsernameQuery("select user_id, pw, active from members where user id=?");
            jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("select user_id, role from roles where user id=?");
            return new JdbcUserDetailsManager(dataSource);
        }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer->
                configurer
                        .requestMatchers("/").hasRole("EMPLOYEE")
                        .requestMatchers("/leaders/**").hasRole("MANAGER")
                        .requestMatchers("/systems/**").hasRole("ADMIN")
                        .anyRequest().authenticated()
        )
                .formLogin(form->
                    form
                        .loginPage("/showMyLoginPage")
                        .loginProcessingUrl("/authenticateUser")
                        .permitAll()
        )
                .logout(logout->logout.permitAll()
        )
                .exceptionHandling(configurer->
                        configurer.accessDeniedPage("/access-denied"));
        return http.build();
    }

}