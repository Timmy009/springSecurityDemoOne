package com.example.demo.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public UserDetailsService userDetailsService () {
        UserDetails u1 = User.builder().username("Timi").password("tim").build();
        UserDetails u2 = User.builder().username("Timi2").password("tim2").build();
         var uds =  new InMemoryUserDetailsManager();
         uds.createUser(u1);
         uds.createUser(u2);
         return uds;
    }

    @Bean public PasswordEncoder passwordEncoder () {
        return NoOpPasswordEncoder.getInstance();
    }
    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception {

        return http
                .httpBasic(Customizer.withDefaults())
                .authorizeHttpRequests(c->c.anyRequest().authenticated())


                .build();
    }
}
