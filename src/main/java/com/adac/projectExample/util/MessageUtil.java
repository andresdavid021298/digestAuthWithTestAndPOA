package com.adac.projectExample.util;

import org.springframework.core.env.Environment;
import org.springframework.util.StringUtils;

public class MessageUtil {

	private Environment environment;
	
	public MessageUtil() {}
	
	public MessageUtil(Environment environment) {
		this.environment = environment;
	}
	
	public String getMessage(String key) {
		String propertyValue = environment.getProperty(key);
		if(!StringUtils.hasText(propertyValue)) throw new NullPointerException("Property not found"); 
		return propertyValue;
	}
	
}
