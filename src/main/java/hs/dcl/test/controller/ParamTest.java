package hs.dcl.test.controller;

import hs.dcl.test.model.User;
import org.springframework.web.bind.annotation.*;

/**
 * @author dacl30868
 * @description: 参数测试
 * @date 2020/7/9 16:26
 */
@RestController
@RequestMapping(value = "/param")
public class ParamTest {

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public void getTest(@RequestParam User user){
        System.out.println(1111);
        System.out.println(user.getAge());
    }

    @RequestMapping(value = "/put", method = RequestMethod.PUT)
    public void putTest(@RequestParam("age") String name){
        System.out.println("45555555555555555555");
        System.out.println(name);
    }

}
