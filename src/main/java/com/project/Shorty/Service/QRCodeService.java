package com.project.Shorty.Service;

import com.project.Shorty.DTO.QRCodeResponseDTO;

public interface QRCodeService {
    public QRCodeResponseDTO generateEAN13BarcodeImage(String longURL);
    public QRCodeResponseDTO generateQRCodeImage(String longURL);
}
