package hs.dcl.test.common;



import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**

 * @Description:    返回结果封装

 * @Author:         weihb


 * @CreateDate:     2019/7/9 14:24

 * @Version:        1.0

 */
@Data
@ToString
public class Result implements Serializable {

    private static final long serialVersionUID = -4896595993756406429L;
    private Long time;
    private Object data;
    private Integer errorNo;
    private String errorInfo;

    public static Result success(Object data) {
        Result result = new Result();
        result.setErrorNo(0);
        result.setErrorInfo("success");
        result.setTime(System.currentTimeMillis());
        result.setData(data);
        return result;
    }

    public static Result success() {
        Result result = new Result();
        result.setErrorNo(0);
        result.setErrorInfo("success");
        result.setTime(System.currentTimeMillis());

        return result;
    }

    /**
     * @param errorEnum 失败原因
     * @param msg       具体失败原因 最好提示用户如何改正
     */
    public static Result failed(ErrorEnum errorEnum, String msg) {
        Result result = new Result();
        result.setErrorNo(errorEnum.code());
        result.setErrorInfo(errorEnum.msg() + " : " + msg);
        result.setTime(System.currentTimeMillis());
        return result;
    }
}