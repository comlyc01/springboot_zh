package com.redis.demo;

import com.redis.demo.entity.Muser;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;


import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.concurrent.TimeUnit;

@SpringBootTest
class DemoApplicationTests {

    @Resource
    private StringRedisTemplate stringRedisTemplate;
    @Resource
    private RedisTemplate redisTemplate;

    @Test
    void contextLoads() {
        stringRedisTemplate.opsForValue().set("aaa", "111");
        String aaa = stringRedisTemplate.opsForValue().get("aaa");
        System.out.println("aaa = " + aaa);

    }

    @Test
    public void testObj() throws Exception {
        Muser user = new Muser("张三", "zhangsan@email.com", "18");
        ValueOperations<String, Muser> operations = redisTemplate.opsForValue();
        operations.set("com.neox", user);
        operations.set("com.neo.f", user, 1, TimeUnit.SECONDS);
        Thread.sleep(1000);
        //redisTemplate.delete("com.neo.f");
        boolean exists = redisTemplate.hasKey("com.neox");
        if (exists) {
            System.out.println("exists is true");
        } else {
            System.out.println("exists is false");
        }
        // Assert.assertEquals("aa", operations.get("com.neo.f").getUserName());
    }

    @Test
    void base64decode() {


    }


}
