package com.example.redistest.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import static com.sun.jmx.snmp.EnumRowStatus.active;

@Data
@Configuration
@ConfigurationProperties(prefix = "spring.redis")
public class RedisConfig {
    // Redis相关连接参数
    private int database;
    private String host;
    private String password;
    private int port;

    // Jedis连接池配置
    @Value("${spring.redis.jedis.pool.max-active}")
    private int maxActive;

    @Value("${spring.redis.jedis.pool.max-idle}")
    private int maxIdle;

    @Value("${spring.redis.jedis.pool.min-idle}")
    private int minIdle;

    @Bean
    public JedisPool jedisPool() {
        // 连接池配置
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        // 读取配置
        poolConfig.setMaxTotal(maxActive);
        poolConfig.setMaxIdle(maxIdle);
        poolConfig.setMinIdle(minIdle);

        JedisPool jedisPool = new JedisPool(poolConfig, host, port, 2000, password, database);

        return jedisPool;
    }
}
