package com.project.Shorty.Exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class URLHashingException extends Exception{
    private String longURL;

    public URLHashingException(String longURL) {
        this.longURL = longURL;
    }

    public URLHashingException(String message, String longURL) {
        super(message);
        this.longURL = longURL;
    }

    public URLHashingException(String message, Throwable cause, String longURL) {
        super(message, cause);
        this.longURL = longURL;
    }

    public URLHashingException(Throwable cause, String longURL) {
        super(cause);
        this.longURL = longURL;
    }

    public URLHashingException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String longURL) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.longURL = longURL;
    }
}
