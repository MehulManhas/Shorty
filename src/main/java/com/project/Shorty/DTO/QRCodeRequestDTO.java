package com.project.Shorty.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class QRCodeRequestDTO {
    @JsonProperty("longURL")
    private String longURL;
}
