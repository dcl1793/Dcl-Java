package hs.dcl.test.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author dacl30868
 * @date 2020/6/18 14:47
 */
@Data
public class User implements Serializable {

    private Long id;

    private String name;

    private Integer age;
}
