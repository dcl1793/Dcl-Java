package hs.dcl.test.model;

import java.io.Serializable;

/**
 * @author dacl30868
 * @date 2020/6/18 14:47
 */
public class User implements Serializable {

    private Long id;

    private String name;

    private int age;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
