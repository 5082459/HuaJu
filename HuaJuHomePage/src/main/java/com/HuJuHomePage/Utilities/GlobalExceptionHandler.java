package com.HuJuHomePage.Utilities;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(RuntimeException.class)//捕获运行时异常
    @ResponseBody
    public Map<String,Integer> exceptionHandler(Exception ex){
        ex.printStackTrace();
        Map<String, Integer> map = new HashMap<>();
        map.put("code", -1);
        return map;
    }
}
