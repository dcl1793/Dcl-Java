package hs.dcl.test;

import hs.dcl.test.dao.CountMapper;
import hs.dcl.test.dao.UserMapper;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class TestApplicationTests {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Resource
    private CountMapper countMapper;

    @Resource
    private UserMapper userMapper;


    @Test
    public void test() throws IOException {

        String s = userMapper.selectById("3213");
        System.out.println("查询到的数据=========="+s);

    }
}

