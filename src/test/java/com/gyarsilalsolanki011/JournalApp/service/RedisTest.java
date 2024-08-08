package com.gyarsilalsolanki011.JournalApp.service;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
public class RedisTest {

    @Autowired
    private RedisTemplate redisTemplate;

    @Disabled
    @Test
    void testSaveMail() {
        redisTemplate.opsForValue().set("mail", "test@gmail.com");
        Object mail = redisTemplate.opsForValue().get("salary");
        System.out.println(mail);
    }
}
