package com.project.Shorty.Model;

import com.fasterxml.jackson.annotation.JsonRawValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class URLMapping extends BaseModel{
    @JsonRawValue
    private String requestedURL;
    private String shortenedURL;
    private String emailId;
    private Integer encodingType;
    private String QRCodeURL;

    public URLMapping() {
    }
}
