package com.example.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)
            throws Exception {
        http.authorizeHttpRequests(auth ->
                        auth
//                                .requestMatchers(HttpMethod.GET, "/").permitAll()
                                .requestMatchers(HttpMethod.POST, "/attendance").hasRole("TEACHER")
                                .anyRequest().authenticated())
                .csrf(AbstractHttpConfigurer::disable)
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }

    @Bean
    public UserDetailsService users(){
        return new InMemoryUserDetailsManager(
                User.withUsername("user")
                        .password(passwordEncoder().encode("parol"))
                        .roles("USER")
                        .build(),
                User.withUsername("teacher")
                        .password(passwordEncoder().encode("teacher"))
                        .roles("TEACHER")
                        .build()
        );
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
