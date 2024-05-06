package com.project.Shorty.Entity;

import com.fasterxml.jackson.annotation.JsonRawValue;
import com.project.Shorty.Enum.EncryptionType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "Custom_URL_Mapping")
public class CustomURLMappingEntity extends BaseEntity{
    @JsonRawValue
    private String requestedURL;
    private String customAlias;
    private String emailId;
    @Enumerated(EnumType.ORDINAL)
    private EncryptionType encodingType;
    private String QRCodeURL;

   public CustomURLMappingEntity(){}

}
