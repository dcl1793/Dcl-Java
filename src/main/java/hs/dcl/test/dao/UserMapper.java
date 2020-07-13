package hs.dcl.test.dao;

import hs.dcl.test.model.Page;
import hs.dcl.test.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author dacl30868
 * @date 2020/6/18 10:34
 */
@Repository
public interface UserMapper {

    List<User> selectUser(Page page);

    /**
     *
     * @return
     */
    Integer selectCountUser();
}
