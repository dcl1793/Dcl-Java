package hs.dcl.test.dao;

import org.springframework.stereotype.Repository;

/**
 * @author dacl30868
 * @date 2020/6/18 10:34
 */
@Repository
public interface UserMapper {

    /**
     * 统计
     * @return Integer
     */
    Integer selectCountUser();

}
