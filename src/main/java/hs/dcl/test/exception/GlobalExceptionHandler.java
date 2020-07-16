package hs.dcl.test.exception;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import hs.dcl.test.common.ErrorEnum;
import hs.dcl.test.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Arrays;

/**
 * @author dacl30868
 * @date 2020/6/19 10:08
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    public static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler
    @ResponseStatus(HttpStatus.OK)
    public Result handle(Exception exception) {
        log.info("全局处理异常：{}", exception.getMessage());
        return Result.failed(ErrorEnum.OPERATION_ERROR, "未知错误");
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.OK)
    public Result handle(MethodArgumentNotValidException exception) {
        BindingResult bindingResult = exception.getBindingResult();
        if (bindingResult != null) {
            return fieldValidateError(bindingResult.getFieldError());
        }
        return Result.failed(ErrorEnum.PARAM_INVALID, exception.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.OK)
    public Result handle(HttpRequestMethodNotSupportedException exception) {
        String method = exception.getMethod();
        String[] supportMethod = exception.getSupportedMethods();
        // log.info("不支持的请求方式[{}]，请使用以下几种方式： {}", method, supportMethod);
        return Result.failed(ErrorEnum.OPERATION_ERROR, String.format("不支持的请求方式[%s]，请使用以下几种方式：%s", method, Arrays.toString(supportMethod)));
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.OK)
    public Result handle(NullPointerException exception) {
        log.error("空指针异常", exception);
        return Result.failed(ErrorEnum.OPERATION_ERROR);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.OK)
    public Result handle(InputException exception) {
        return Result.failed(ErrorEnum.PARAM_INVALID, exception.getMsg());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.OK)
    public Result handle(BindException exception) {
        return fieldValidateError(exception.getFieldError());
    }

    private Result fieldValidateError(FieldError fieldError) {
        String msg = fieldError.getDefaultMessage();
        Object input = fieldError.getRejectedValue();
        String code = fieldError.getCode();
        String field = fieldError.getField();
        if ("typeMismatch".equals(code)) {
            return Result.failed(ErrorEnum.PARAM_INVALID, "参数【" + field + "】格式不正确 输入参数：" + input);
        }
        return Result.failed(ErrorEnum.PARAM_INVALID, msg + " 输入参数：" + input);
    }


//    @ExceptionHandler
//    @ResponseStatus(HttpStatus.OK)
//    public Result handle(HttpMessageNotReadableException exception) {
//        log.error(exception.toString());
//        InvalidFormatException invalidFormatException = (InvalidFormatException) exception.getCause();
//        //String StringtargetType = invalidFormatException.getTargetType().getTypeName();
//        String fieldName = invalidFormatException.getPath().get(0).getFieldName();
//        return Result.failed(ErrorEnum.PARAM_INVALID,fieldName+"格式不正确！");
//    }

}
