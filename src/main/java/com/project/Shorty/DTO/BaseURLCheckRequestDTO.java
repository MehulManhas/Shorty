package com.project.Shorty.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class BaseURLCheckRequestDTO {
    @JsonProperty("url")
    String url;
}
