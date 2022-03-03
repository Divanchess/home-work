package com.sbrf.reboot.spring.beans.annotations;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@PropertySource("app.properties")
@Configuration
public class ConfigAnnotation {
    @Bean(initMethod = "printInitMessage")
    public AccountAnnotation accountAnnotationConfig(ClientAnnotation client, @Value("${currency}") String currency) {
        return new AccountAnnotation("BFLDJFH1458457", currency, client);
    }

    @Bean
    public ClientAnnotation clientAnnotationConfig() {
        return new ClientAnnotation("John");
    }
}
