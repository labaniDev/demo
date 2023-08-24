package com.example.demo.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import lombok.Getter;
import lombok.Setter;

@ConfigurationPropertiesScan 
@ConfigurationProperties(prefix = "login")
@Getter
@Setter
public class LoginProperties {
	
	
	private String jwtCookieName;
    private String jwtSecret;
    private long jwtExpirationMs;

}
