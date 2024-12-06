package com.adac.projectExample.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.adac.projectExample.util.MessageUtil;

@Configuration
@PropertySource("classpath:message.properties")
public class MessageConfig {

	@Autowired
	private Environment env;
	
	@Bean
	public MessageUtil getMessageUtil() {
		return new MessageUtil(env);
	}
	
}
