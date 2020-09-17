package hs.dcl.test.service.impl;

import hs.dcl.test.common.ResultBody;
import hs.dcl.test.dao.IncentiveObjMapper;
import hs.dcl.test.model.IncentiveObj;
import hs.dcl.test.model.Page;
import hs.dcl.test.service.IncentiveObjService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author dacl30868
 * @date 2020/6/21 15:18
 */
@Service
public class incentiveObjServiceImpl implements IncentiveObjService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IncentiveObjMapper incentiveObjMapper;

    @Override
    public ResultBody getPersonDetail(Page page) {

        IncentiveObj incentiveObjs = incentiveObjMapper.selectAll();
        return hs.dcl.test.common.ResultBody.success(incentiveObjs);
    }
}
