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
    NOT_FOUND(1, "资源不存在"),
    @Deprecated
    NAME_NOT_EMPTY(2, "名称不能为空"),
    PARAM_NOT_EMPTY(3, "参数不能为空"),
    PARAM_INVALID(4, "参数非法"),
    PARAM_IS_EXIST(5, "已存在"),
    UNKNOWN_ERROR(6, "未知错误"),
    SF_ERROR(7, "自定义业务错误"),
    OPERATION_ERROR(8, "操作失败"),
    EXPORT_FAIL(9, "导出错误"),
    IMPORT_FAIL(10, "导入错误"),


    /**
     * 身份认证/授权类异常
     */
    AUTH(10000, "身份认证/授权异常"),
    VALIDATE(20000, "参数验证异常"),
    BUSINESS(30000, "业务异常"),


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
