package hs.dcl.test.dao;

import hs.dcl.test.model.IncentiveObj;
import org.springframework.stereotype.Repository;

@Repository
public interface IncentiveObjMapper {

    int deleteByPrimaryKey(Integer objectId);

    IncentiveObj selectAll();

    Integer countByExample();
}