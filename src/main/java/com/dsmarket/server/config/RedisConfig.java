package com.dsmarket.server.config;

import java.time.Duration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.dsmarket.server.dto.request.RegisterRequest;

@Configuration
public class RedisConfig {

    private final String hostname;

    private final int port;

    private final int database;

    private final String password;

    private final long timeout;

    public RedisConfig(
        @Value("${redis.host}") String hostname,
        @Value("${redis.port}") int port,
        @Value("${redis.database}") int database,
        @Value("${redis.password}") String password,
        @Value("${redis.timeout}") long timeout
    ) {

        this.hostname = hostname;
        this.port = port;
        this.database = database;
        this.password = password;
        this.timeout = timeout;
    }

    @Bean
    public RedisConnectionFactory redisConnectionFactory() 
    {
        
    	RedisStandaloneConfiguration config = new RedisStandaloneConfiguration();
        config.setHostName(hostname);
        config.setPort(port);
        config.setDatabase(database);
        config.setPassword(password);

        LettuceClientConfiguration clientConfig = 
        		LettuceClientConfiguration
        		.builder()
        		.commandTimeout(Duration.ofSeconds(timeout))
        		.build();

        return new LettuceConnectionFactory(config, clientConfig);
    }
    
    @Bean
    public RedisTemplate<String, Object> redisTemplate()
    {
    	RedisTemplate<String, Object> rt = new RedisTemplate<>();
    	rt.setConnectionFactory(redisConnectionFactory());
    	rt.setKeySerializer(new StringRedisSerializer());
    	return rt;
    }
}