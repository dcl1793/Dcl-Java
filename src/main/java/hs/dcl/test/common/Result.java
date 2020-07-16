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
    private Integer code;
    private String msg;

    @Deprecated
    private Result() {
    }

    public static Result success(Object data) {
        Result result = new Result();
        result.setCode(0);
        result.setMsg("success");
        result.setTime(System.currentTimeMillis());
        result.setData(data);
        return result;
    }

    public static Result success() {
        Result result = new Result();
        result.setCode(0);
        result.setMsg("success");
        result.setTime(System.currentTimeMillis());
        return result;
    }

    public static Result failed(ErrorEnum errorEnum) {
        Result result = new Result();
        result.setCode(errorEnum.code());
        result.setMsg(errorEnum.msg());
        result.setTime(System.currentTimeMillis());

        return result;
    }

    public static Result failed(ErrorEnum errorEnum, String msg) {
        Result result = new Result();
        result.setCode(errorEnum.code());
        result.setMsg(errorEnum.msg() + " : " + msg);
        result.setTime(System.currentTimeMillis());

        return result;
    }

    /**
     * 返回失败结果时  尽量返回详细失败信息
     */
    @Deprecated
    public static Result failed() {
        return new Result(ErrorEnum.PARAM_INVALID);
    }

    /**
     * 外部类 推荐使用该类静态方法创建实例对象
     */
    @Deprecated
    public Result(ErrorEnum errorEnum) {
        setCode(errorEnum.code());
        setMsg(errorEnum.msg());
        setTime(System.currentTimeMillis());
    }

    /**
     * 外部类 推荐使用该类静态方法创建实例对象
     */
    @Deprecated
    public Result(Integer code, String msg) {
        setCode(code);
        setMsg(msg);
        setTime(System.currentTimeMillis());
    }

}