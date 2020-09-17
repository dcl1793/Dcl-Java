package hs.dcl.test.exception;

import lombok.Getter;

public class InputException extends RuntimeException {
    @Getter
    private String msg;
    
    public InputException(String msg) {
        super(msg);
        this.msg = msg;
    }
}
