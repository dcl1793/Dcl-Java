package hs.dcl.test.controller;

import hs.dcl.test.common.Result;
import hs.dcl.test.model.Page;
import hs.dcl.test.service.PageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dacl30868
 * @date 2020/6/19 13:42
 */
@RestController
@RequestMapping(value = "/exception")
public class ExceptionTestController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PageService pageService;

    /**
     * 全局异常测试
     */
    @RequestMapping(value = "/test1", method = RequestMethod.GET)
    public Result excepTest()  {
        Result result = pageService.excepTest();
        return result;
    }

    /**
     * 自定义异常测试
     */
    @RequestMapping(value = "/test2", method = RequestMethod.GET)
    public Result sfExcep()  {
        Result result = pageService.sfExcep();
        return result;
    }
}
