package hs.dcl.test.dao;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountMapper {

    List<String> selectImei ();

}
