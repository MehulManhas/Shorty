package com.project.Shorty.Exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShortenedURLNotFoundException extends Exception{
    private String shortenedURL;

    public ShortenedURLNotFoundException(String shortenedURL) {
        this.shortenedURL = shortenedURL;
    }

    public ShortenedURLNotFoundException(String message, String shortenedURL) {
        super(message);
        this.shortenedURL = shortenedURL;
    }

    public ShortenedURLNotFoundException(String message, Throwable cause, String shortenedURL) {
        super(message, cause);
        this.shortenedURL = shortenedURL;
    }

    public ShortenedURLNotFoundException(Throwable cause, String shortenedURL) {
        super(cause);
        this.shortenedURL = shortenedURL;
    }

    public ShortenedURLNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String shortenedURL) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.shortenedURL = shortenedURL;
    }
}
