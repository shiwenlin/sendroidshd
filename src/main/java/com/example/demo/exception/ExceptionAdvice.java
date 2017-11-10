package com.example.demo.exception;


import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Component
public class ExceptionAdvice {


    @ExceptionHandler({RuntimeException.class})
    public String handlerRuntimeException(Exception e){
        e.printStackTrace();
        return "error";
    }
}
