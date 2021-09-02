package hs.dcl.test.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import hs.dcl.test.common.RedisConstants;
import hs.dcl.test.common.ResultBody;
import hs.dcl.test.model.Page;
import hs.dcl.test.model.dto.RedisInfo;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/redis")
public class RedisController {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ResultBody addRedis(@RequestParam String corpsId,@RequestParam String value)  {

        //存入redis中
        redisTemplate.opsForHash().put("CREATE_COMMAND", RedisConstants.CREATE_CHANNEL+corpsId, value);
        redisTemplate.expire("CREATE_COMMAND", RedisConstants.CREATE_COMMAND_KEEP_TIME, TimeUnit.SECONDS);

        return ResultBody.success();
    }

    @RequestMapping(value = "/add1", method = RequestMethod.GET)
    public ResultBody addRedis1(@RequestParam String corpsId,@RequestParam String value)  {

        //存入redis中
        redisTemplate.opsForHash().put("CREATE_COMMAND", RedisConstants.CREATE_COMMAND+corpsId, value);
        redisTemplate.expire("CREATE_COMMAND", RedisConstants.CREATE_COMMAND_KEEP_TIME, TimeUnit.SECONDS);

        return ResultBody.success();
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public ResultBody getRedis( )  {

        Map<Object, Object> map = redisTemplate.opsForHash().entries("CREATE_COMMAND");
        List<RedisInfo> redisInfos = new ArrayList<>();

        if(!map.isEmpty()){
            Iterator<Map.Entry<Object,Object>> it=map.entrySet().iterator();

            while(it.hasNext()){

                Map.Entry<Object,Object> entry=it.next();
                RedisInfo redisInfo = new RedisInfo();
                redisInfo.setKey(entry.getKey().toString());
                redisInfo.setValue(entry.getValue().toString());
                redisInfos.add(redisInfo);
                redisTemplate.opsForHash().delete("CREATE_COMMAND", entry.getKey().toString());
            }
        }

        return ResultBody.success(redisInfos);
    }

    @RequestMapping(value = "/getHttpRedis", method = RequestMethod.GET)
    public ResultBody getHttpRedis( )  {

        //发送http请求给中转服务
        String url = "http://localhost:8388/test/redis/get";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity entity = new HttpEntity<>(headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> exchange = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);


        String body = exchange.getBody();
        JSONObject jsonObj = JSONObject.parseObject(body);
        String error_no = jsonObj.getString("code");
        if ("200".equals(error_no)) {
            String data = jsonObj.getString("data");

            List<RedisInfo> buttons = JSON.parseArray(data, RedisInfo.class);


        } else {
            String errorMsg = jsonObj.getString("message");
        }
        return ResultBody.success();
    }

}
