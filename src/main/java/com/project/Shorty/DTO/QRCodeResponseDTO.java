package com.project.Shorty.DTO;

import com.project.Shorty.Enum.QRCodeType;
import lombok.Data;

@Data
public class QRCodeResponseDTO {
    private byte[] imageData;
    private QRCodeType qrCodeType;
}
