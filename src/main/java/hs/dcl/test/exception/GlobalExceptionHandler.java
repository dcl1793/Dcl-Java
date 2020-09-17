package hs.dcl.test.exception;

import cn.hutool.core.util.StrUtil;
import hs.dcl.test.common.CommonEnum;
import hs.dcl.test.common.ResultBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
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

    @Value("${application.showError:true}")
    private final boolean showError = true;

    @ExceptionHandler
    @ResponseStatus(HttpStatus.OK)
    public ResultBody handle(Exception exception) {
        log.error("未知错误 : ", exception);
        Throwable cause = rootCause(exception.getCause());
        if (cause != null) {
            return ResultBody.failed(CommonEnum.INTERNAL_SERVER_ERROR, cause.getMessage());
        } else {
            return ResultBody.failed(CommonEnum.INTERNAL_SERVER_ERROR, exception.getMessage());
        }
    }

    private Throwable rootCause(Throwable throwable) {
        if (throwable == null) {
            return null;
        }
        Throwable cause = throwable.getCause();
        if (cause != null) {
            return rootCause(cause);
        }
        return throwable;
    }

    /**
     * 参数绑定异常,显示错误参数，为防止入参过长，我们只取入参的前10位。
     * @param exception
     * @return
     */
    @ExceptionHandler
    @ResponseStatus(HttpStatus.OK)
    public ResultBody handle(BindException exception) {
        showError(exception);
        return fieldValidateError(exception.getFieldError());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.OK)
    public ResultBody handle(MethodArgumentNotValidException exception) {
        showError(exception);
        BindingResult bindingResult = exception.getBindingResult();
        if (bindingResult != null) {
            return fieldValidateError(bindingResult.getFieldError());
        }
        return ResultBody.failed(CommonEnum.BODY_NOT_MATCH, exception.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.OK)
    public ResultBody handle(HttpRequestMethodNotSupportedException exception) {
        showError(exception);
        String method = exception.getMethod();
        String[] supportMethod = exception.getSupportedMethods();
        return ResultBody.failed(CommonEnum.BODY_NOT_MATCH, String.format("不支持的请求方式[%s]，请使用以下几种方式：%s", method, Arrays.toString(supportMethod)));
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.OK)
    public ResultBody handle(NullPointerException exception) {
        showError(exception);
        return ResultBody.failed(CommonEnum.INTERNAL_SERVER_ERROR, "NPE");
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.OK)
    public ResultBody handle(InputException exception) {
        showError(exception);
        return ResultBody.failed(CommonEnum.BODY_NOT_MATCH, exception.getMessage());
    }


    private ResultBody fieldValidateError(FieldError fieldError) {
        String msg = fieldError.getDefaultMessage();
        Object input = fieldError.getRejectedValue();
        String code = fieldError.getCode();
        String field = fieldError.getField();
        log.error("参数【{}】格式不正确 输入参数：{}", field, input);
        String errorInfo = StrUtil.sub(String.valueOf(input), 0, 10);
        if ("typeMismatch".equals(code)) {
            return ResultBody.failed(CommonEnum.BODY_NOT_MATCH, "参数【" + field + "】格式不正确 输入参数：" + errorInfo);
        }
        return ResultBody.failed(CommonEnum.BODY_NOT_MATCH, msg + " 输入参数：" + errorInfo);
    }

    private void showError(Exception e) {
        if (showError) {
            log.error("异常 : ", e);
        }
    }
}
