package ru.aveskin.petclinic.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> auth
                                .requestMatchers("api/v1/accounts/register").permitAll()
                                .requestMatchers("/error").permitAll()
//                        .requestMatchers("api/v1/demo/role-owner-auth").hasRole("OWNER")
//                        .requestMatchers("api/v1/demo/role-admin-auth").hasRole("ADMIN")
//                        .requestMatchers("api/v1/demo/role-vet-auth").hasRole("VET")
                                .requestMatchers(HttpMethod.GET, "/api/v1/owners/**").permitAll()
                                .requestMatchers(HttpMethod.POST, "/api/v1/owners/**").hasAnyRole("ADMIN", "OWNER")
                                .requestMatchers(HttpMethod.PUT, "/api/v1/owners/**").hasAnyRole("ADMIN", "OWNER")
                                .requestMatchers(HttpMethod.DELETE, "/api/v1/owners/**").hasAnyRole("ADMIN", "OWNER")
                                .requestMatchers(HttpMethod.GET, "/api/v1/vets/**").permitAll()
                                .requestMatchers(HttpMethod.POST, "/api/v1/vets/**").hasAnyRole("ADMIN", "VET")
                                .requestMatchers(HttpMethod.PUT, "/api/v1/vets/**").hasAnyRole("ADMIN", "VET")
                                .requestMatchers(HttpMethod.DELETE, "/api/v1/vets/**").hasAnyRole("ADMIN", "VET")
                                .requestMatchers(HttpMethod.GET, "/api/v1/pets/my").hasRole("OWNER")
                                .requestMatchers(HttpMethod.POST, "/api/v1/pets").hasAnyRole("OWNER", "ADMIN")
                                .requestMatchers(HttpMethod.PUT, "/api/v1/pets").hasAnyRole("OWNER", "ADMIN")
                                .requestMatchers(HttpMethod.DELETE, "/api/v1/pets").hasAnyRole("OWNER", "ADMIN")

                                .anyRequest().authenticated()
                )
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}