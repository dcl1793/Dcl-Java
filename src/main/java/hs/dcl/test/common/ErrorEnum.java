package hs.dcl.test.common;

import lombok.Data;

/**
 * @author dacl30868
 * @date 2020/6/18 19:14
 */
public enum ErrorEnum {

    /**
     * 一般异常
     */
    PARAM_INVALID(200400, "参数非法"),
    NOT_FOUND(200404, "资源不存在"),
    OPERATION_FAILED(200408, "操作失败"),
    INTERNAL_ERROR(200500, "内部错误"),
    ;
    private final String msg;

    private final int code;

    ErrorEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String msg() {
        return msg;
    }

    public int code() {
        return code;
    }
}
