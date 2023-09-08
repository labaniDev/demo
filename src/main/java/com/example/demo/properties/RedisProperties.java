package com.example.demo.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

import lombok.Getter;
import lombok.Setter;

@ConfigurationPropertiesScan 
@ConfigurationProperties(prefix = "redis")
@Getter
@Setter
public class RedisProperties {
	
	private String host;
	private Integer port;

}
