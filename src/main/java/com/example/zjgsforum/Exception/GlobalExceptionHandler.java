package com.example.zjgsforum.Exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(SameAccountException.class)
    public Result handlerSameAccountException(SameAccountException e) {
        return new Result(500, e.getMessage());
    }

    @ExceptionHandler(NullElementException.class)
    public Result handlerNullElementException(NullElementException e) {
        return new Result(500, e.getMessage());
    }

    @ExceptionHandler(IllegalDataException.class)
    public Result handlerIllegalDataException(IllegalDataException e) {
        return new Result(500, e.getMessage());
    }

    @ExceptionHandler(UploadException.class)
    public Result handlerIllegalDataException(UploadException e) {
        return new Result(500, e.getMessage());
    }
}
