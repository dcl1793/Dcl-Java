package hs.dcl.test.service.impl.springtransaction;

import hs.dcl.test.generator.domain.Student;
import hs.dcl.test.generator.mapper.StudentMapper;
import hs.dcl.test.service.springtransaction.TestTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TestTransactionServiceImpl implements TestTransactionService {


    @Autowired
    StudentMapper studentMapper;

    @Transactional(rollbackFor = Exception.class)
    public void test2(){
        Student studentForInsert = new Student();
        studentForInsert.setId(new Long(19));
        studentForInsert.setName("测试11");
        studentMapper.updateById(studentForInsert);
        System.out.println(1/0);
    }
}
