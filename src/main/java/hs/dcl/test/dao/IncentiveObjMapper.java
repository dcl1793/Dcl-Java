package hs.dcl.test.dao;

import hs.dcl.test.model.IncentiveObj;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.yaml.snakeyaml.events.Event;

import java.util.List;

@Repository
public interface IncentiveObjMapper {

    int deleteByPrimaryKey(Integer objectId);

    IncentiveObj selectAll();

    Integer countByExample();
}