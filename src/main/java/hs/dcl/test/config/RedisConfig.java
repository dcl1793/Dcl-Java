package hs.dcl.test.config;

import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import javax.annotation.Resource;

@Configuration
@EnableConfigurationProperties(RedisProperties.class)
public class RedisConfig {
    @Resource
    private RedisProperties redisProperties;

    @Bean
    public JedisPool jedisPool() {
        String host = redisProperties.getHost();
        int port = redisProperties.getPort();

        JedisPoolConfig config = new JedisPoolConfig();
        config.setBlockWhenExhausted(true);

        return new JedisPool(config, host, port);
    }
}
