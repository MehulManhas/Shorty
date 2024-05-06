package com.project.Shorty.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CustomURLRequestDTO {
    @JsonProperty("longUrl")
    private String longUrl;
    @JsonProperty("customAlias")
    private String customAlias;
}
