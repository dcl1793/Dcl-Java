package hs.dcl.test.controller.springtransaction;

import hs.dcl.test.service.springtransaction.TestRollbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/transaction")
public class TestController {

    @Autowired
    TestRollbackService testRollbackService;

    @RequestMapping("/test1")
    public void test1(){
        try{
            testRollbackService.test1();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
