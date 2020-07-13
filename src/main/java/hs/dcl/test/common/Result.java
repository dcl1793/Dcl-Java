package hs.dcl.test.common;



import java.io.Serializable;

/**

 * @Description:    返回结果封装

 * @Author:         weihb


 * @CreateDate:     2019/7/9 14:24

 * @Version:        1.0

 */
public class Result implements Serializable {
    private Long time;
    private Object data;
    private Integer errorNo;
    private String errorInfo;

    public Result() {
    }

    public Result(Object data) {
        setData(data);
        setErrorNo(0);
        setErrorInfo("success");
        setTime(System.currentTimeMillis());
    }

    public static  Result okResult() {
        Result result = new  Result();
        result.setErrorNo(0);
        result.setErrorInfo("success");
        result.setTime(System.currentTimeMillis());

        return result;
    }

    public Result(ErrorEnum errorEnum) {
        setErrorNo(errorEnum.getCode());
        setErrorInfo(errorEnum.getMsg());
        setTime(System.currentTimeMillis());
    }

    public Result(Integer code, String msg) {
        setErrorNo(code);
        setErrorInfo(msg);
        setTime(System.currentTimeMillis());
    }
    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Integer getErrorNo() {
        return errorNo;
    }

    public void setErrorNo(Integer errorNo) {
        this.errorNo = errorNo;
    }

    public String getErrorInfo() {
        return errorInfo;
    }

    public void setErrorInfo(String errorInfo) {
        this.errorInfo = errorInfo;
    }

    @Override
    public String toString() {
        return "Result{" +
                "time=" + time +
                ", data=" + data +
                ", errorNo='" + errorNo + '\'' +
                ", errorInfo='" + errorInfo + '\'' +
                '}';
    }
}