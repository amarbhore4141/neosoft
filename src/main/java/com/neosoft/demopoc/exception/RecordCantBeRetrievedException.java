package com.neosoft.demopoc.exception;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RecordCantBeRetrievedException extends RuntimeException {
//    private int statusCode;
//    private String errorMessage;



    public RecordCantBeRetrievedException(String s) {
        super(s);
    }

    public RecordCantBeRetrievedException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public RecordCantBeRetrievedException(Throwable throwable) {
        super(throwable);
    }

    public RecordCantBeRetrievedException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }



}
