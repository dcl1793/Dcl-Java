package hs.dcl.test.service.impl;

import hs.dcl.test.common.ErrorEnum;
import hs.dcl.test.common.Result;
import hs.dcl.test.dao.UserMapper;
import hs.dcl.test.exception.BaseBizException;
import hs.dcl.test.model.Page;
import hs.dcl.test.model.User;
import hs.dcl.test.service.PageService;
import hs.dcl.test.util.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;

/**
 * @author dacl30868
 * @date 2020/6/18 9:58
 */
@Service
public class PageServiceImpl implements PageService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional(rollbackFor = {Exception.class, Error.class})
    public Result getPersonDetail(Page page) throws BaseBizException {

        try {

            Integer totalNum = userMapper.selectCountUser();
            PageHelper pageHelper = new PageHelper(page.getPage(), page.getRows());
            page.setPage((page.getPage() - 1)*page.getRows());
            List<User> list = userMapper.selectUser(page);
            pageHelper.setDataInfo(list);
            pageHelper.setTotalCount(totalNum);
            return Result.success(pageHelper);

        }catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.failed(ErrorEnum.OPERATION_ERROR);
        }
    }

    @Override
    public Result excepTest() {

        return Result.success();
    }

    /**
     * 自定义异常测试
     */
    @Override
    public Result sfExcep() {
        try {
            if (1 > 0) {
                throw new BaseBizException("自定义异常");
            }
        } catch (BaseBizException e) {
            logger.error(e.getMsg());
            e.printStackTrace();
            Result result = new Result(ErrorEnum.SF_ERROR.code(), e.getMsg());
            return result;

        }
        return new Result(ErrorEnum.PARAM_INVALID);
    }

}
