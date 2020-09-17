package hs.dcl.test.common;


/**
 * @author dacl30868
 * @date 2020/6/18 19:14
 */
public enum CommonEnum {

    /**
     * 一般异常
     */
    SUCCESS(200200, "成功!"),
    BODY_NOT_MATCH(200400,"请求的数据格式不符!"),
    SIGNATURE_NOT_MATCH(200401,"请求的数字签名不匹配!"),
    NOT_FOUND(200404, "未找到该资源!"),
    INTERNAL_SERVER_ERROR(200500, "服务器内部错误!"),
    SERVER_BUSY(200503,"服务器正忙，请稍后再试!")
    ;
    private final String msg;

    private final int code;

    CommonEnum(int code, String msg) {
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
