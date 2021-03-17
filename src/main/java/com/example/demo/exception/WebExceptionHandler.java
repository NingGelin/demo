package com.example.demo.exception;

import com.example.demo.model.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.stream.Collectors;

/**
 * 异常统一捕捉处理类
 */
@ControllerAdvice
public class WebExceptionHandler {
    public static final Logger logger = LoggerFactory.getLogger(WebExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ApiResponse ExceptionConvert(Exception e)
    {
        if (e instanceof HttpMessageNotReadableException)
        {
            // body体为空异常捕获
            return new ApiResponse(false, -1, e.getMessage());
        }
        else if (e instanceof MethodArgumentNotValidException)
        {
            // body体参数为空异常捕获
            String message = ((MethodArgumentNotValidException) e).getBindingResult().getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining());
            return new ApiResponse(false, -1, message);
        }
        else if (e instanceof MissingServletRequestParameterException)
        {
            // get请求参数为空异常捕获
            String message = ((MissingServletRequestParameterException) e).getParameterName() + "不能为空";
            return new ApiResponse(false, -1, message);
        }
        else
        {
            // 未知异常打印日志，返回服务内部异常
            logger.warn("server error: ", e);
            return new ApiResponse(false, -1, "服务内部异常");
        }
    }
}

