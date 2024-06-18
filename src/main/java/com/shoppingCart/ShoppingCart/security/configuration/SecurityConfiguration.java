package com.shoppingCart.ShoppingCart.security.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Autowired
    private JwtTokenFilter jwtTokenFilter;

    @Autowired
    JwtEntryPoint entryPoint;
    
    /**
     * public urls without requiring authentication
     */
    public final String[] PUBLIC_URL = {"/auth/**", "/v3/api-docs.yaml",
                                                                        "/v3/api-docs/**",
                                                                        "/swagger-ui/**",
                                                                        "/swagger-ui.html"};

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())

            .authorizeHttpRequests(requests -> {
                requests.requestMatchers(PUBLIC_URL).permitAll().anyRequest().authenticated();
            })
            .exceptionHandling(e -> e.authenticationEntryPoint(entryPoint))
            .sessionManagement(management -> {
                management.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
            })
            .addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

}
