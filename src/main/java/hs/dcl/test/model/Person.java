package hs.dcl.test.model;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.io.Serializable;

@Data
public class Person implements Serializable {

    /**
     * 名称
     */
    @Excel(name = "用户名",orderNum = "0",width = 15)
    private String name;

    /**
     * 年龄
     */
    @Excel(name = "年龄",orderNum = "1",width = 15)
    private int age;

}
