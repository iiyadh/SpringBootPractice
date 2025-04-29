package com.isett.lab3advenced.bookcatalog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers("/api/**").permitAll()
                                .requestMatchers("/actuator/health", "/actuator/info").permitAll()
                                .requestMatchers("/actuator/**").hasRole("ADMIN")
                                .anyRequest().authenticated()
                )
                .httpBasic();

        return http.build();
    }
}
