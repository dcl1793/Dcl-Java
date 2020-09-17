package hs.dcl.test.service;

import hs.dcl.test.common.ResultBody;
import hs.dcl.test.model.Page;

/**
 * @author dacl30868
 * @date 2020/6/18 9:58
 */
public interface PageService {

    /**
     * 获取人员详情
     *
     * @param page 分页
     * @return Result
     */
    ResultBody getPersonDetail(Page page);

    /**
     * 获取人员详情
     *
     * @return Result
     */
    ResultBody exceptTest();

    /**
     * 获取人员详情
     *
     * @return Result
     */
    ResultBody sfexcepetion();

}
