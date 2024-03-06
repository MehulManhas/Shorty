package com.project.Shorty.DTO;

import lombok.Data;

@Data
public class ErrorResponseDTO {
    private String requestedURL;
    private String shortenedURL;
    private String message;
    private int errorCode;
}
