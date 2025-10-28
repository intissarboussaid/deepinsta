package com.deepinsta.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
	
	
	 private  AuthenticationProvider authenticationProvider;
     private  JwtAuthenticationFilter jwtAuthentificationFilter ;
     
     public SecurityConfiguration(JwtAuthenticationFilter jwtAuthentificationFilter, AuthenticationProvider authenticationProvider) {
             this.jwtAuthentificationFilter = jwtAuthentificationFilter;
             this.authenticationProvider = authenticationProvider;
          }

/*@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.csrf()//verification
		.disable()
		.authorizeHttpRequests()
		.requestMatchers("api/auth/**")
		.permitAll()
		.anyRequest()
		.authenticated()
		.and()
		.sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()
		.authenticationProvider(authenticationProvider)
		.addFilterBefore(jwtAuthentificationFilter, UsernamePasswordAuthenticationFilter.class);
		
		
		return http.build();
	}
     
   @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/auth/**")
                        .permitAll()
                        .anyRequest()
                        .authenticated()
                )
                .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthentificationFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }*/
     @Bean
     public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
         http
             .csrf().disable()
             .authorizeHttpRequests()
                 .requestMatchers("/api/deepinsta/admin/**").permitAll() // Allow these
                 .requestMatchers("/api/deepinsta/auth/**").permitAll()
                 .requestMatchers("/api/deepinsta/photo/**").permitAll() 
                 .requestMatchers("/api/deepinsta/product/**").permitAll() 
                 .requestMatchers("/api/deepinsta/product_manager/**").permitAll() 
                 .requestMatchers("/api/deepinsta/user/**").permitAll()
                 .requestMatchers("/api/deepinsta/rating/**").permitAll() 
                 .requestMatchers("/api/deepinsta/forgetPassword/**").permitAll()
                 .requestMatchers("/api/deepinsta/discount/**").permitAll()
                 .requestMatchers("/api/deepinsta/view/product/**").permitAll()                
                 .requestMatchers("/api/deepinsta/commentaire/**").permitAll()
                 .requestMatchers("/api/deepinsta/commande/**").permitAll()
                 .requestMatchers("/api/deepshop/fav/**").permitAll()
                 .requestMatchers("/api/deepshop/contact/**").permitAll()
                 .requestMatchers("/api/deepshop/customers/**").permitAll()
                 .requestMatchers("api/deepshop/codePromo/**").permitAll()
                 .anyRequest().authenticated() // Protect everything else
             .and()
             .sessionManagement()
                 .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
             .and()
             .authenticationProvider(authenticationProvider)
             .addFilterBefore(jwtAuthentificationFilter, UsernamePasswordAuthenticationFilter.class);

         return http.build();
     }

}
