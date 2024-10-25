package it.poli.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@Slf4j
public class SecurityConfig {

  @Bean
  SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    log.info("SSO is disabled. Continuing using LDAP Authentication.");

    http.csrf(AbstractHttpConfigurer::disable)
        .authorizeHttpRequests(req -> req.requestMatchers("/login").permitAll())
        .authorizeHttpRequests(
            req ->
                req.requestMatchers(
                        HttpMethod.GET,
                        "/images/**",
                        "/js/**",
                        "/css/**",
                        "/webjars/**",
                        "/resources/**",
                        "/jakarta.faces.resource/**",
                        "/jakarta.faces.resource/images/**")
                    .permitAll());

    return http.build();
  }
}
