package hs.dcl.test.generator.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import hs.dcl.test.generator.domain.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
* @author admin
* @description 针对表【student】的数据库操作Mapper
* @createDate 2022-03-11 16:20:53
* @Entity generator.domain.Student
*/
@Repository
@Mapper
public interface StudentMapper extends BaseMapper<Student> {

}




