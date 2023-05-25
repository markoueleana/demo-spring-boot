package com.demoapp.springcore.config;

import com.demoapp.springcore.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean("inTheWater")
    public SwimCoach swimCoach(){
       return new SwimCoach();
    }
}
