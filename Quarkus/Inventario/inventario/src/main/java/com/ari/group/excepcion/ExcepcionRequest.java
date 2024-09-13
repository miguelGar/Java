package com.ari.group.excepcion;

public class ExcepcionRequest extends RuntimeException{

    private final int errorCode;

    public ExcepcionRequest(String message, int errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }
    public ExcepcionRequest(String message, Throwable cause, int errorCode) {
        super(message, cause);
        this.errorCode = errorCode;
    }
}
