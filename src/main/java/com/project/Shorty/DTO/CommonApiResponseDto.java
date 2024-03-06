package com.project.Shorty.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.Shorty.Util.Util;
import lombok.*;
import org.springframework.http.HttpStatus;

import java.sql.Timestamp;

@Getter
@Builder
@AllArgsConstructor
public class CommonApiResponseDto<T> {
    private  T data;
    @Builder.Default
    private Timestamp time = Util.getCurrentTimeStamp();
    @Builder.Default
    @JsonProperty("is_success")
    private Boolean success = false;
    @JsonProperty("status_code")
    public HttpStatus httpCode;
}
