package dev.heming.example.restful.exception;

import dev.heming.example.restful.result.CommonResult;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.ValidationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

/**
 * @Description 全局异常处理
 * @Author Bess Croft
 * @Date 2023/10/11 17:33
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 处理 SpringMVC 请求参数缺失
     *
     * 例如说，接口上设置了 @RequestParam("xx") 参数，结果并未传递 xx 参数
     */
    @ResponseBody
    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    public CommonResult<?> missingServletRequestParameterExceptionHandler(MissingServletRequestParameterException ex) {
        log.warn("SpringMVC 请求参数缺失.[异常原因={}]", ex.getMessage(), ex);
        return CommonResult.ERROR(HttpStatus.BAD_REQUEST.value(),
                String.format("请求参数缺失:%s", ex.getParameterName()), null);
    }

    /**
     * 处理 SpringMVC 请求参数类型错误
     *
     * 例如说，接口上设置了 @RequestParam("xx") 参数为 Integer，结果传递 xx 参数类型为 String
     */
    @ResponseBody
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public CommonResult<?> methodArgumentTypeMismatchExceptionHandler(MethodArgumentTypeMismatchException ex) {
        log.warn("SpringMVC 请求参数类型错误.[异常原因={}]", ex.getMessage(), ex);
        return CommonResult.ERROR(HttpStatus.BAD_REQUEST.value(),
                String.format("请求参数类型错误:%s", ex.getMessage()), null);
    }

    /**
     * SpringMVC 参数校验不正确
     */
    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public CommonResult<?> methodArgumentNotValidExceptionExceptionHandler(MethodArgumentNotValidException ex) {
        log.warn("SpringMVC 参数校验异常.[异常原因={}]", ex.getMessage(), ex);
        FieldError fieldError = ex.getBindingResult().getFieldError();
        assert fieldError != null; // 断言，避免告警
        return CommonResult.ERROR(HttpStatus.BAD_REQUEST.value(),
                String.format("请求参数不正确:%s", fieldError.getDefaultMessage()), null);
    }

    /**
     * SpringMVC 参数绑定不正确，本质上也是通过 Validator 校验
     */
    @ResponseBody
    @ExceptionHandler(BindException.class)
    public CommonResult<?> bindExceptionHandler(BindException ex) {
        log.warn("SpringMVC 参数绑定异常.[异常原因={}]", ex.getMessage(), ex);
        FieldError fieldError = ex.getFieldError();
        assert fieldError != null; // 断言，避免告警
        return CommonResult.ERROR(HttpStatus.BAD_REQUEST.value(),
                String.format("请求参数不正确:%s", fieldError.getDefaultMessage()), null);
    }

    /**
     * Validator 请求参数校验异常
     */
    @ResponseBody
    @ExceptionHandler(value = ConstraintViolationException.class)
    public CommonResult<?> constraintViolationExceptionHandler(ConstraintViolationException ex) {
        log.warn("Validator 请求参数校验异常.[异常原因={}]", ex.getMessage(), ex);
        ConstraintViolation<?> constraintViolation = ex.getConstraintViolations().iterator().next();
        return CommonResult.ERROR(HttpStatus.BAD_REQUEST.value(),
                String.format("请求参数不正确:%s", constraintViolation.getMessage()), null);
    }

    /**
     * 参数校验 ValidationException 异常
     */
    @ResponseBody
    @ExceptionHandler(value = ValidationException.class)
    public CommonResult<?> validationException(ValidationException ex) {
        log.warn("参数校验 ValidationException 异常.[异常原因={}]", ex.getMessage(), ex);
        return CommonResult.ERROR(HttpStatus.BAD_REQUEST.value(), ex.getMessage(), null);
    }

    /**
     * SpringMVC 请求方法异常
     */
    @ResponseBody
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public CommonResult<?> httpRequestMethodNotSupportedExceptionHandler(HttpRequestMethodNotSupportedException ex) {
        log.warn("SpringMVC 请求方法异常.[异常原因={}]", ex.getMessage(), ex);
        return CommonResult.ERROR(HttpStatus.FORBIDDEN.value(), ex.getMessage(), null);
    }

    /**
     * 参数异常 IllegalArgumentException
     */
    @ResponseBody
    @ExceptionHandler(IllegalArgumentException.class)
    public CommonResult<?> handleException(IllegalArgumentException ex) {
        log.error("参数异常.[异常原因={}]", ex.getMessage(), ex);
        return CommonResult.ERROR(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage(), null);
    }

    /**
     * 全局异常拦截 handleException
     */
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public CommonResult<?> handleException(Exception ex) {
        log.error("全局异常信息.[异常原因={}]", ex.getMessage(), ex);
        return CommonResult.ERROR(HttpStatus.INTERNAL_SERVER_ERROR.value(), "系统异常，请联系管理员！", null);
    }

}
