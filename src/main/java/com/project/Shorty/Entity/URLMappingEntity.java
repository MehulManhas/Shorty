package com.project.Shorty.Entity;

import com.fasterxml.jackson.annotation.JsonRawValue;
import com.project.Shorty.Enum.EncryptionAlgorithm;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "URL_Mapping")
public class URLMappingEntity extends BaseEntity {
    @JsonRawValue
    private String requestedURL;
    private String shortenedURL;
    private String emailId;
    @Enumerated(EnumType.ORDINAL)
    private EncryptionAlgorithm encodingType;
    private String QRCodeURL;

    public URLMappingEntity() {
    }
}
