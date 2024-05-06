package com.project.Shorty.Controller;

import com.project.Shorty.DTO.QRCodeRequestDTO;
import com.project.Shorty.DTO.QRCodeResponseDTO;
import com.project.Shorty.Service.QRCodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class QRCodeController {
    private final QRCodeService qrCodeService;

    @PostMapping("/generateQRCode1D")
    public ResponseEntity<QRCodeResponseDTO> createQRCode1D(@RequestBody QRCodeRequestDTO qrCodeRequestDTO) {
        QRCodeResponseDTO qrCodeResponseDTO = qrCodeService.generateEAN13BarcodeImage(qrCodeRequestDTO.getLongURL());
        return new ResponseEntity<>(qrCodeResponseDTO, HttpStatus.OK);
    }
    @PostMapping("/generateQRCode2D")
    public ResponseEntity<QRCodeResponseDTO> createQRCode2D(@RequestBody QRCodeRequestDTO qrCodeRequestDTO) {
        QRCodeResponseDTO qrCodeResponseDTO = qrCodeService.generateQRCodeImage(qrCodeRequestDTO.getLongURL());
        return new ResponseEntity<>(qrCodeResponseDTO, HttpStatus.OK);
    }
}
