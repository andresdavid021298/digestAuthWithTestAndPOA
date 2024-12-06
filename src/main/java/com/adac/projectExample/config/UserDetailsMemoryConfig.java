package com.adac.projectExample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class UserDetailsMemoryConfig {

	@Bean
	UserDetailsService usersMemory() {
		UserDetails user = User.builder().username("user").password("userPass").build();
		UserDetails admin = User.builder().username("admin").password("adminPass").build();
		return new InMemoryUserDetailsManager(user, admin);
	}

}
