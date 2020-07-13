package hs.dcl.test.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author dacl30868
 * @date 2020/6/19 10:08
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    public static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler
    @ResponseStatus(HttpStatus.OK)
    public Result handle(Exception exception) {
        logger.info(exception.getMessage());
        return  new Result(ErrorEnum.UNKNOW_ERROR);
    }
}
