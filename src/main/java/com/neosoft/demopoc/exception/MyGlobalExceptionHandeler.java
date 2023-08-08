package com.neosoft.demopoc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestControllerAdvice
public class MyGlobalExceptionHandeler {
    @ExceptionHandler(RecordCantBeRetrievedException.class)
    public ResponseEntity<CustomErrorMessage> recordCantBeRetrievedExceptionGlobal(RecordCantBeRetrievedException e){
        CustomErrorMessage customErrorMessage=new CustomErrorMessage();
        customErrorMessage.setTimeStamp(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date()));
        customErrorMessage.setMessage(e.getMessage());
        customErrorMessage.setCode(400);

        return new ResponseEntity<>(customErrorMessage,HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(NoSuchAlgorithmException.class)
    public ResponseEntity<String> noSuchAlgorithmExceptionCustom(NoSuchAlgorithmException e){
        return ResponseEntity.status(500).body("Encryption algorithm is missing"+e.getMessage()+""+e.getCause());
    }
}
