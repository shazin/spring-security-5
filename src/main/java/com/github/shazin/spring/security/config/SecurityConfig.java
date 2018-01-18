package com.github.shazin.spring.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.HttpSecurity;
import org.springframework.security.core.userdetails.MapUserDetailsRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsRepository;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

    @Bean
    public SecurityWebFilterChain springWebFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeExchange()
                .pathMatchers("/user").authenticated()
                .anyExchange().permitAll()
                .and()
                .build();
    }


    @Bean
    public UserDetailsRepository userDetailsRepository() {
        UserDetails userDetails = User.withUsername("shazin").password("sha123").roles("USER").build();
        return new MapUserDetailsRepository(userDetails);
    }
}
