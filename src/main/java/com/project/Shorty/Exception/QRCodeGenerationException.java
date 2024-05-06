package com.project.Shorty.Exception;

public class QRCodeGenerationException extends RuntimeException{
    private String message;

    public QRCodeGenerationException(String message) {
        this.message = message;
    }

    public QRCodeGenerationException(String message, String message1) {
        super(message);
        this.message = message1;
    }

    public QRCodeGenerationException(String message, Throwable cause, String message1) {
        super(message, cause);
        this.message = message1;
    }

    public QRCodeGenerationException(Throwable cause, String message) {
        super(cause);
        this.message = message;
    }

    public QRCodeGenerationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String message1) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.message = message1;
    }
}
