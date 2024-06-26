package com.project.Shorty.Exception;

public class EntitySaveException extends RuntimeException{
    String message;
    public EntitySaveException(String message){}

    public EntitySaveException() {
        super();
    }

    public EntitySaveException(String message, Throwable cause) {
        super(message, cause);
    }

    public EntitySaveException(Throwable cause) {
        super(cause);
    }

    protected EntitySaveException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
