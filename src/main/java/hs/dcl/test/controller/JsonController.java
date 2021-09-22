package hs.dcl.test.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import hs.dcl.test.common.JsonResultBody;
import hs.dcl.test.common.ResultBody;
import hs.dcl.test.exception.BaseBizException;
import hs.dcl.test.model.dto.GraphDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;

/**
 * @Auther: dcl
 * @Date: 2021/9/22 19:49
 * @Description: json解析测试类
 */
public class JsonController {

    private final Logger logger = LoggerFactory.getLogger(JsonController.class.getSimpleName());

    /**
     * @Author dcl
     * @Description json解析测试1
     * @Date 2021/9/22 20:07
     * @Param
     * @return
     */
    @RequestMapping(value = "/test1", method = RequestMethod.GET)
    public ResultBody test1()  {
        try{
            //发送http请求给中转服务
            String url = "http:127.0.0.1:8303/cbs/ferry/equip/app/appCorpDevList";
            HttpHeaders headers = new HttpHeaders();
            headers.add("head","head");
            HashMap<String, Object> params = new HashMap<>();
            params.put("corpId", "1");
            HttpEntity entity = new HttpEntity<>(params,headers);
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> exchange = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
            String body = exchange.getBody();
            logger.debug("app查询设备列表拿到的body:" + body);
            //json是个对象
            JSONObject jsonObj = JSONObject.parseObject(body);
            String error_no = jsonObj.getString("status");
            if ("OK".equals(error_no)) {
                String data = jsonObj.getString("data");
                if(StringUtils.isEmpty(data)){
                    return  ResultBody.success();
                }else {
                    //json是个array
                    List<Object> result =  JSONArray.parseArray(data,Object.class);
                    return ResultBody.success(result);
                }
            } else {
                String errorMsg = jsonObj.getString("message");
                logger.error("调用530侧获取设备列表接口失败："+errorMsg);
                throw new BaseBizException("调用5X0侧获取设备列表接口失败："+errorMsg);
            }
        } catch (Exception e) {
            logger.error("GA网侧通过摆渡服务拿到设备列表失败: ", e);
            throw new BaseBizException("内部错误："+e.getMessage());
        }
    }



    /**
     * @Author dcl
     * @Description json解析测试2
     * @Date 2021/9/22 20:08
     * @Param
     * @return
     */
    @RequestMapping(value = "/test2", method = RequestMethod.GET)
    public ResultBody test2() throws Exception {

            //发送http请求给中转服务
            String url = "http:127.0.0.1:8303/cbs/ferry/equip/app/appCorpDevList";
            HttpHeaders headers = new HttpHeaders();
            headers.add("head","head");
            HashMap<String, Object> params = new HashMap<>();
            params.put("corpId", "1");
            HttpEntity entity = new HttpEntity<>(params,headers);
            RestTemplate restTemplate = new RestTemplate();
            String body;
            try{
                ResponseEntity<String> exchange = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
                body = exchange.getBody();
                logger.debug("查询设备缩略图url:{}, 返回值:{}", url, body);
            }catch (Exception e){
                logger.error("向ZK服务,请求获取设备缩略图失败:", e);
                throw new Exception("向ZK服务,请求获取设备缩略图失败:" + e.toString());
            }

            logger.debug("app查询设备列表拿到的body:" + body);
            //json是个对象
            JsonResultBody<GraphDTO> response = JSONObject.parseObject(body,
                    new TypeReference<JsonResultBody<GraphDTO>>() {
                    });

            JsonResultBody<List<GraphDTO>> responseList = JSONObject.parseObject(body,
                    new TypeReference<JsonResultBody<List<GraphDTO>>>() {
                    });

            if (null == response) {
                throw new Exception("ZK服务,提供的设备列表数据格式异常: 无法正常解析");
            }

            if (response.getSuccess() == null || !response.getSuccess()) {
                logger.warn("查询设备缩略图失败, errorCode:{}, errorMsg:{}", response.getErrorCode(), response.getErrorMsg());
                throw new Exception("查询设备缩略图失败, 原因:" + response.getErrorMsg());
            }

            GraphDTO data = response.getData();
            return ResultBody.success(data);
        }
    }
}