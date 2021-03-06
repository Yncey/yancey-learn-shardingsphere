package com.yancey.learn;

import com.yancey.learn.utils.RedisUtil;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.Test;

import javax.annotation.Resource;

@SpringBootTest
public class RedisTests extends AbstractTransactionalTestNGSpringContextTests {

    @Resource
    private RedisUtil redis;

    @Test
    public void testGet() {
        redis.set("name", "123545");
        System.out.println(redis.getStr("name"));
        System.out.println(redis.ttl("name"));
        redis.expire("name", 5L);
        System.out.println(redis.ttl("name"));
//        redis.del("name");
    }

}
