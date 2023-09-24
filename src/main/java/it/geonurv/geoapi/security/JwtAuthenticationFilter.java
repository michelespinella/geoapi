package it.geonurv.geoapi.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {


    private Logger log = LogManager.getLogger(JwtAuthenticationFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                    FilterChain filterChain) throws ServletException, IOException {

        if (SecurityContextHolder.getContext().getAuthentication() instanceof JwtAuthenticationToken) {
            Set<SimpleGrantedAuthority> authorities = new HashSet<>();

            JwtAuthenticationToken jwtAuthenticationToken = (JwtAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();


            log.info("Token issuer: "+jwtAuthenticationToken.getTokenAttributes().get("iss"));
            Object userId = jwtAuthenticationToken.getTokenAttributes().get("sub");
            log.debug("Logged user: "+userId.toString());
            Object scopes = jwtAuthenticationToken.getTokenAttributes().get("scope");
            log.debug("Scope inbound: "+scopes.toString());
            log.info("Token roles: "+jwtAuthenticationToken.getTokenAttributes().get("roles"));
            if(userId != null && scopes.toString().contains("istat")) {

                ArrayList<String> userRoles = new ArrayList<>();
                userRoles.add("geoapi");
                for (Object r : userRoles) {
                    SimpleGrantedAuthority authority = new SimpleGrantedAuthority(r.toString());
                    authorities.add(authority);
                }


                for (GrantedAuthority a : jwtAuthenticationToken.getAuthorities()) {
                    SimpleGrantedAuthority simpleGrantedAuthority = (SimpleGrantedAuthority) a;
                    authorities.add(simpleGrantedAuthority);
                }

                JwtAuthenticationToken newAuth = new JwtAuthenticationToken(jwtAuthenticationToken.getToken(), authorities);
                SecurityContextHolder.getContext().setAuthentication(newAuth);
            } else if (scopes.toString().contains("agreed:wa")) {
                for (GrantedAuthority a : jwtAuthenticationToken.getAuthorities()) {
                    SimpleGrantedAuthority simpleGrantedAuthority = (SimpleGrantedAuthority) a;
                    authorities.add(simpleGrantedAuthority);
                }

                JwtAuthenticationToken newAuth = new JwtAuthenticationToken(jwtAuthenticationToken.getToken(), authorities);
                SecurityContextHolder.getContext().setAuthentication(newAuth);
            }

        }

        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }

}
