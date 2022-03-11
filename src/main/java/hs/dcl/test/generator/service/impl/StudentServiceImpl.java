package hs.dcl.test.generator.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import hs.dcl.test.generator.domain.Student;
import hs.dcl.test.generator.mapper.StudentMapper;
import hs.dcl.test.generator.service.StudentService;
import org.springframework.stereotype.Service;

/**
* @author admin
* @description 针对表【student】的数据库操作Service实现
* @createDate 2022-03-11 16:20:53
*/
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

}




