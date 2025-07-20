package com.deepinsta.config;



import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.micrometer.common.lang.NonNull;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;


@Component //this annotation make this class run first
@RequiredArgsConstructor//it will create any constructor using any filing field 
public class JwtAuthenticationFilter extends OncePerRequestFilter{
	
    private UserDetailsService userDetailsService;
	private  JwtService jwtService;
	
	@Override
	protected void doFilterInternal( @NonNull  HttpServletRequest request,@NonNull HttpServletResponse response,@NonNull FilterChain filterChain)
			throws ServletException, IOException {
		final String authHeader=request.getHeader("authorization");
		final String jwt;
		final String email;
		
		if(authHeader==null || !authHeader.startsWith("Bearer")) {
			filterChain.doFilter(request, response);
			 return;
		}
		jwt= authHeader.substring(7);// Bearer nbre 7 
		email= jwtService.extractEmail(jwt);	//to do extract the user email from JWT
		if(email != null && SecurityContextHolder.getContext().getAuthentication()==null) {
			UserDetails userDetails = this.userDetailsService.loadUserByUsername(email);
			if(jwtService.isTokenValid(jwt, userDetails)) {
				UsernamePasswordAuthenticationToken authToken= new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
				authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(authToken);
			}
		}
		filterChain.doFilter(request, response);
	}


	    
}
