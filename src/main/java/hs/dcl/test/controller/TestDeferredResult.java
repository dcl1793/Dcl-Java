package hs.dcl.test.controller;

import hs.dcl.test.model.dto.OperatorVideo;
import hs.dcl.test.model.dto.ResponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.TimeUnit;

@RestController
public class TestDeferredResult {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private static final ResponseResult<OperatorVideo> OUT_OF_TIME_RESULT = new ResponseResult<OperatorVideo>("out time","超时",new OperatorVideo());


    @GetMapping("test")
    public DeferredResult<ResponseEntity<String>> testDeferredResult(){
        DeferredResult<ResponseEntity<String>> deferredResult = new DeferredResult(3*1000l,OUT_OF_TIME_RESULT);

        deferredResult.onCompletion(
                new Runnable() {
                    @Override
                    public void run() {
                        logger.info("success");
                    }
                });

        deferredResult.onTimeout(
                new Runnable() {
                    @Override
                    public void run() {
                        logger.info("timeout");
                    }
                });

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                deferredResult.setErrorResult(e.getMessage());
            }
            deferredResult.setResult(ResponseEntity.ok("SUCCESS"));
        }).start();

        return deferredResult;
    }


}
