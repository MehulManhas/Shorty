package com.project.Shorty.Entity;

import com.fasterxml.jackson.annotation.JsonRawValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class URLMappingEntity extends BaseEntity {
    @JsonRawValue
    private String requestedURL;
    private String shortenedURL;
    private String emailId;
    private Integer encodingType;
    private String QRCodeURL;

    public URLMappingEntity() {
    }
}
