package it.geonurv.geoapi.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class LogFilter extends OncePerRequestFilter {
    private Logger log = LoggerFactory.getLogger(LogFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                    FilterChain filterChain) throws ServletException, IOException {
        log.info("Received " + httpServletRequest.getMethod() + " request with URI " + httpServletRequest
                .getRequestURI() + " from client " + httpServletRequest
                .getRemoteAddr() + " and host: " + httpServletRequest
                .getRemoteHost() + " with X-FORWARDED-FOR " + getIp(httpServletRequest,
                "X-FORWARDED-FOR") + " and X-FORWARDED-HOST " + getIp(httpServletRequest,
                "X-FORWARDED-HOST") + " and X-REAL-IP " + getIp(httpServletRequest, "X-REAL-IP"));

        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }

    private String getIp(HttpServletRequest request, String httpHeader) {
        String remoteAddr = "";

        if (request != null) {
            remoteAddr = request.getHeader(httpHeader);
            if (remoteAddr == null || "".equals(remoteAddr)) {
                remoteAddr = request.getRemoteAddr();
            }
        }

        return remoteAddr;
    }
}