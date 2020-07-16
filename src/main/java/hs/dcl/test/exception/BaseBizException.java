package hs.dcl.test.exception;

import lombok.Data;

/**
 * @author dacl30868
 * @date 2020/6/19 13:31
 */
@Data
public class BaseBizException extends RuntimeException{

    private int code;

    private String msg;

    public BaseBizException(String msg) {
        this.msg = msg;
    }

    public BaseBizException(Integer code,String msg) {
        this.code = code;
        this.msg = msg;
    }
}
