package com.zml.exception;

import org.h2.jdbc.JdbcSQLException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class MyControllerAdvice{


    @ExceptionHandler(value = MyException.class)
    @ResponseBody
    public ResponseEntity handlerMyException(Exception ex) {

        return ResponseEntity.badRequest().body(ex.getMessage());
    }





}
