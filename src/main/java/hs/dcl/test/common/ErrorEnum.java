package hs.dcl.test.common;

/**
 * @author dacl30868
 * @date 2020/6/18 19:14
 */
public enum ErrorEnum {

    NOT_FOUND(1,"暂无"),
    NAME_NOT_EMPTY(2,"名称不能为空"),
    PARAM_NOT_EMPTY(3,"参数不能为空"),
    PARAM_NOT_NORMAL(4,"参数非法"),
    PARAM_IS_EXSIT(5,"已存在"),
    UNKNOW_ERROR(6,"未知错误"),
    SF_ERROR(7,"内部错误"),
    OPERATION_ERROR(8,"操作失败");

    private String msg;

    private int code;

    private ErrorEnum(int code, String msg){
        this.code=code;
        this.msg=msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
