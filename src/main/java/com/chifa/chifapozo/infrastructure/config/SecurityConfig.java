package com.chifa.chifapozo.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration // -> Se usa para configurar la seguridad del sistema
@EnableWebSecurity // -> Para usar reglas de seguridad personalizadas para las rutas de mi aplicación web
public class SecurityConfig {

    @Bean // -> Le dice a Spring que el resultado del método debe ser gestionado como un "servicio"
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .cors(cors -> cors.configurationSource(corsConfigurationSource()))
                // Desactiva la protección CSRF (útil si no usas formularios, por ejemplo, con Postman o API REST).
                .csrf(AbstractHttpConfigurer::disable)
                // Protege todas las rutas y pide que el usuario esté autenticado.
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().authenticated()
                )
                // Usa autenticación básica (usuario y contraseña en cada request, como Postman o navegador).
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }

    // Crea un usuario en la memoria
    @Bean
    public UserDetailsService users() {
        UserDetails user = User.builder()
                .username("user")
                .password(passwordEncoder().encode("1234"))
                .roles()
                .build();
        return new InMemoryUserDetailsManager(user);
    }

    // Encriptar la contraseña
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.addAllowedOrigin("http://localhost:5173"); // frontend Vite
        configuration.addAllowedMethod("*"); // permite GET, POST, PUT, DELETE, etc
        configuration.addAllowedHeader("*"); // permite todos los headers
        configuration.setAllowCredentials(true); // permite enviar cookies

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
