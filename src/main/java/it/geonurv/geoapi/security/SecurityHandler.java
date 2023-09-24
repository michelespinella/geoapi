package it.geonurv.geoapi.security;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Component;

@Component("securityHandler")
public class SecurityHandler {

	public Boolean isIstatUser() {
		if (SecurityContextHolder.getContext().getAuthentication() instanceof JwtAuthenticationToken) {
			JwtAuthenticationToken jwtAuthenticationToken = (JwtAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
			var roles = ((Jwt)jwtAuthenticationToken.getCredentials()).getClaims().get("roles");
			if (roles == null){
				return false;
			}
			return roles.toString().contains("geoapi");
		}
		return false;
		}
	
	public Boolean isAdmin() {
		if (SecurityContextHolder.getContext().getAuthentication() instanceof JwtAuthenticationToken) {
			JwtAuthenticationToken jwtAuthenticationToken = (JwtAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
			var roles = ((Jwt)jwtAuthenticationToken.getCredentials()).getClaims().get("roles");
			if(roles == null){
				return false;
			}
			return  roles.toString().contains("role_admin");
		}
		return false;
	}
}
