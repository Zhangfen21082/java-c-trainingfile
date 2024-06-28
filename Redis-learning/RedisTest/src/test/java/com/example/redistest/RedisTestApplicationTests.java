package com.example.redistest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@SpringBootTest
class RedisTestApplicationTests {
    @Autowired
    private JedisPool jedisPool;
    @Test
    void contextLoads() {
        Jedis jedis = jedisPool.getResource();
        System.out.println(jedis.ping());

    }

}
