package com.project.Shorty.Controller.ControllerAdvice;

import com.project.Shorty.DTO.ErrorResponseDTO;
import com.project.Shorty.Exception.ShortenedURLNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalControllerAdvice {

    @ExceptionHandler(value = ShortenedURLNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleShortenedURLNotFoundException(String requestedURL, String shortenedURL, Exception exception){
        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO();
        errorResponseDTO.setRequestedURL(requestedURL);
        errorResponseDTO.setShortenedURL(shortenedURL);
        errorResponseDTO.setMessage(exception.getMessage());
        errorResponseDTO.setErrorCode(404);

        return new ResponseEntity<ErrorResponseDTO>(errorResponseDTO, HttpStatus.NOT_FOUND);
    }
}
