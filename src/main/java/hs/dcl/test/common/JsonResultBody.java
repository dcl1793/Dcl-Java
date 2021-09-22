package hs.dcl.test.common;

import lombok.Data;
import org.apache.poi.ss.formula.functions.T;

/**
 * @Auther: dcl
 * @Date: 2021/9/22 20:11
 * @Description: 对接第三方出参，可根据实际情况进行修改
 */
@Data
public class JsonResultBody<T> {

    // 查询是否成功
    private Boolean success;

    // 失败编码
    private String errorCode;

    private String errorMsg;

    private T data;
}