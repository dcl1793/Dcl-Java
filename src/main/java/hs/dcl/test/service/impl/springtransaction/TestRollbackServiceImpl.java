package hs.dcl.test.service.impl.springtransaction;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import hs.dcl.test.generator.domain.Student;
import hs.dcl.test.generator.service.StudentService;
import hs.dcl.test.service.springtransaction.TestRollbackService;
import hs.dcl.test.service.springtransaction.TestTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TestRollbackServiceImpl implements TestRollbackService {

    @Autowired
    private StudentService studentService;

    @Autowired
    TestTransactionService testTransactionService;

    @Transactional(rollbackFor = Exception.class)
    public void test1(){
        QueryWrapper querywrapper = new QueryWrapper();
        querywrapper.eq("id", new Long(1));
        Student one = studentService.getOne(querywrapper);
        try{
            testTransactionService.test2();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
