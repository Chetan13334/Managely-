package com.managely.config;

import com.managely.models.Manager;
import com.managely.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Autowired
    private ManagerRepository managerRepository;

    @Bean
    public UserDetailsService userDetailsService() {
        return username -> {
            Manager manager = managerRepository.findByUsername(username)
                    .orElseThrow(() -> new UsernameNotFoundException("Manager not found"));
            return User.builder()
                    .username(manager.getUsername())
                    .password(manager.getPassword())
                    .roles("MANAGER")
                    .build();
        };
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return  NoOpPasswordEncoder.getInstance(); // Secure encoding
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.cors()
        .and()
        .csrf().disable()
            .authorizeHttpRequests()
            .requestMatchers("/api/**").authenticated()
            .anyRequest().permitAll()
            .and()
            .httpBasic(); // Basic auth

        return http.build();
    }
}
