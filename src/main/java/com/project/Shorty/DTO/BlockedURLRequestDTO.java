package com.project.Shorty.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class BlockedURLRequestDTO {
    @JsonProperty("blockedURL")
    String blockedURL;
}
