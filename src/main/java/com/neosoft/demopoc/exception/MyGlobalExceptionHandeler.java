package com.neosoft.demopoc.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.security.NoSuchAlgorithmException;

@RestControllerAdvice
public class MyGlobalExceptionHandeler {
    @ExceptionHandler(RecordCantBeRetrievedException.class)
    public ResponseEntity<String> recordCantBeRetrievedExceptionGlobal(RecordCantBeRetrievedException e){
        return ResponseEntity.status(500).body("Either Field is missing : "+e.getMessage());
    }

    @ExceptionHandler(NoSuchAlgorithmException.class)
    public ResponseEntity<String> noSuchAlgorithmExceptionCustom(NoSuchAlgorithmException e){
        return ResponseEntity.status(500).body("Encryption algorithm is missing"+e.getMessage()+""+e.getCause());
    }
}
