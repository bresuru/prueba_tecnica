package com.consult.customer.config;

import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MainConfig {

    @Bean
    public ErrorPageRegistrar errorPageRegistrar(){
        return new ErrorPageRegistrarConfig();
    }

}
