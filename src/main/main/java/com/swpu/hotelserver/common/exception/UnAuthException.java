package com.swpu.hotelserver.common.exception;

public class UnAuthException extends RuntimeException {


    public UnAuthException(String msg) {
        super(msg);
    }

    public UnAuthException() {
        super();
    }


}
