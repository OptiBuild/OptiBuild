package com.optibuild.website;

import org.springframework.ai.autoconfigure.vectorstore.redis.RedisVectorStoreAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = {RedisVectorStoreAutoConfiguration.class})
public class OptiBuildWebsiteApplication {
	public static void main(String[] args) {SpringApplication.run(OptiBuildWebsiteApplication.class, args);
	}

}
