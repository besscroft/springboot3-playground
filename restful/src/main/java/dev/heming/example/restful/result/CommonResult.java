package dev.heming.example.restful.result;

import lombok.Data;
import org.springframework.http.HttpStatus;

/**
 * @Description 泛型通用返回对象
 * @Author Bess Croft
 * @Date 2023/10/11 16:06
 */
@Data
public class CommonResult<T> {

    /** 状态码 */
    private int code;

    /** 消息 */
    private String message;

    /** 数据对象 */
    private T data;

    /**
     * 初始化一个新创建的 CommonResult 对象，使其表示一个空消息。
     */
    public CommonResult() {
    }

    /**
     * 初始化一个新创建的 CommonResult 对象
     * @param code 状态码
     * @param message 消息提示
     * @param data 数据对象
     */
    public CommonResult(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * 成功封装方法
     * @return 成功消息
     */
    public static CommonResult OK() {
        return OK("调用成功！");
    }

    /**
     * 成功封装方法
     * @param message 消息提示
     * @param <T>
     * @return 成功消息
     */
    public static <T> CommonResult<T> OK(String message) {
        return new CommonResult<T>(HttpStatus.OK.value(), message, null);
    }

    /**
     * 成功封装方法
     * @param data 数据对象
     * @param <T>
     * @return 成功消息
     */
    public static <T> CommonResult<T> OK(T data) {
        return new CommonResult<T>(HttpStatus.OK.value(), "调用成功！", data);
    }

    /**
     * 成功封装方法
     * @param message 消息提示
     * @param data 数据对象
     * @param <T>
     * @return 成功消息
     */
    public static <T> CommonResult<T> OK(String message, T data) {
        return new CommonResult<T>(HttpStatus.OK.value(), message, data);
    }

    /**
     * 失败封装方法
     * @return 错误消息
     */
    public static CommonResult ERROR() {
        return ERROR("调用失败");
    }

    /**
     * 失败封装方法
     * @param message 消息提示
     * @param <T>
     * @return 错误消息
     */
    public static <T> CommonResult<T> ERROR(String message) {
        return new CommonResult<T>(HttpStatus.INTERNAL_SERVER_ERROR.value(), message, null);
    }

    /**
     * 失败封装方法
     * @param data 数据对象
     * @param <T>
     * @return 错误消息
     */
    public static <T> CommonResult<T> ERROR(T data) {
        return new CommonResult<T>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "调用失败！", data);
    }

    /**
     * 失败封装方法
     * @param message 消息提示
     * @param data 数据对象
     * @param <T>
     * @return 错误消息
     */
    public static <T> CommonResult<T> ERROR(String message, T data) {
        return new CommonResult<T>(HttpStatus.INTERNAL_SERVER_ERROR.value(), message, data);
    }

    /**
     * 失败封装方法
     * @param code 数据对象
     * @param message 消息提示
     * @param <T>
     * @return 错误消息
     */
    public static <T> CommonResult<T> ERROR(int code, String message) {
        return new CommonResult<T>(HttpStatus.INTERNAL_SERVER_ERROR.value(), message, null);
    }

    /**
     * 失败封装方法
     * @param code 数据对象
     * @param message 消息提示
     * @param data 数据对象
     * @param <T>
     * @return 错误消息
     */
    public static <T> CommonResult<T> ERROR(int code, String message, T data) {
        return new CommonResult<T>(code, message, data);
    }

}
