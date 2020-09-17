package hs.dcl.test.controller;

import hs.dcl.test.common.ResultBody;
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
 * @date 2020/6/18 9:47
 */
@RestController
@RequestMapping(value = "/page")
public class PageController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PageService pageService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResultBody pageTest(Page page)  {
        ResultBody resultBody = pageService.getPersonDetail(page);
        return resultBody;
    }


    @RequestMapping(value = "/sfexcepetion", method = RequestMethod.GET)
    public ResultBody sfexcepetion()  {
        ResultBody sfexcepetion = pageService.sfexcepetion();
        return sfexcepetion;
    }
}
