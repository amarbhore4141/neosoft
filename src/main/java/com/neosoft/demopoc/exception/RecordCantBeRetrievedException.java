package com.neosoft.demopoc.exception;

public class RecordCantBeRetrievedException extends RuntimeException {
    public RecordCantBeRetrievedException() {
    }

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
