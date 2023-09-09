package com.example.demo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import lombok.Data;
import lombok.experimental.Accessors;
@Data
@Accessors(chain = true)
@RedisHash("cacheData")
public class CacheData {
	
	public CacheData(String string, String productsAsJsonString) {
		
	}
	@Id
	private String key;
	@Indexed
	private String value;
	
	

}
