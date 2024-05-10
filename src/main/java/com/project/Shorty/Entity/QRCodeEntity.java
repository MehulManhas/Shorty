package com.project.Shorty.Entity;

import com.project.Shorty.Enum.QRCodeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "QRCode")
public class QRCodeEntity extends BaseEntity{
    private String longURL;
    private String shortURL;
    private byte[] imageData;
    private String storagePath;
    private String emailId;
    @Enumerated(EnumType.ORDINAL)
    private QRCodeType qrCodeType;
}
