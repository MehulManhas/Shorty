package com.project.Shorty.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
public class BaseURLCheckResponseDTO {
    @JsonProperty("blocked")
    private boolean blocked = false;
    private String message;
}
