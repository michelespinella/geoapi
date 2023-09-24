package it.geonurv.geoapi.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.jwt.JwtDecoders;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.expression.WebExpressionAuthorizationManager;

import static org.springframework.security.config.Customizer.withDefaults;

@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
@Configuration
public class SecurityConfiguration {

    @Value("${spring.security.debug:false}")
    boolean securityDebug;

    @Value("${kc.auth.issuerUri}")
    private String issuerUri;

    @Value("${server.servlet.context-path}")
    private String basePath;
    
/*    @Bean
    @Order(1)
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((requests) -> {
            try {
                requests.requestMatchers("/**").access(new WebExpressionAuthorizationManager("isAuthenticated"))
                        .and().oauth2ResourceServer()
                        .jwt(jwt -> jwt.decoder(JwtDecoders.fromIssuerLocation(issuerUri)))
                        .and().sessionManagement()
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().csrf().disable().cors();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        return http.build();
    }*/

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((requests) -> {
            try {
                requests.requestMatchers("/api/v1/*").access(new WebExpressionAuthorizationManager("isAuthenticated"))
                        .and().oauth2ResourceServer()
                        .jwt(jwt -> jwt.decoder(JwtDecoders.fromIssuerLocation(issuerUri)))
                        .and().sessionManagement()
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().csrf().disable().cors();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        return http.build();
    }


    
}