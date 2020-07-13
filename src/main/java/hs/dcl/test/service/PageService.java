package hs.dcl.test.service;

import hs.dcl.test.common.Result;
import hs.dcl.test.model.Page;

/**
 * @author dacl30868
 * @date 2020/6/18 9:58
 */
public interface PageService {

    /**
     * 获取人员详情
     * @param page
     * @return
     */
    Result getPersonDetail(Page page);

    Result excepTest();

    Result sfExcep();
}
