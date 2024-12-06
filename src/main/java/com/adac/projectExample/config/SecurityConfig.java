package com.adac.projectExample.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.DigestAuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.DigestAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Value("${auth.digest.real.name}")
	private String realNameAuth;
	
	@Value("${auth.digest.key}")
	private String keyAuth;
	
	@Autowired
	private UserDetailsMemoryConfig userDetailsMemoryConfig;
	
    @Bean
    DigestAuthenticationEntryPoint digestEntryPoint() {
        DigestAuthenticationEntryPoint entryPoint = new DigestAuthenticationEntryPoint();
        entryPoint.setRealmName(realNameAuth);
        entryPoint.setKey(keyAuth);
        return entryPoint;
    }
    
    public DigestAuthenticationFilter digestAuthenticationFilter() {
        DigestAuthenticationFilter authenticationFilter = new DigestAuthenticationFilter();
        authenticationFilter.setUserDetailsService(userDetailsMemoryConfig.usersMemory());
        authenticationFilter.setCreateAuthenticatedToken(true);
        authenticationFilter.setAuthenticationEntryPoint(digestEntryPoint());
        return authenticationFilter;
    }
	
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
        .addFilter(digestAuthenticationFilter())
        .exceptionHandling(excep -> excep.authenticationEntryPoint(digestEntryPoint()))
        .authorizeHttpRequests(request -> request
			.requestMatchers("/customer/**").permitAll()
			.requestMatchers("/product/**").permitAll()
			.anyRequest().authenticated()
		)
		.cors(corsConfig -> corsConfig.disable())
		.csrf(csrfConfig -> csrfConfig.disable());
		return httpSecurity.build();
	}
	
}
