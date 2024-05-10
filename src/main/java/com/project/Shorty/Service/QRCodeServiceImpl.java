package com.project.Shorty.Service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.oned.EAN13Writer;
import com.google.zxing.qrcode.QRCodeWriter;
import com.project.Shorty.DTO.QRCodeResponseDTO;
import com.project.Shorty.Entity.QRCodeEntity;
import com.project.Shorty.Enum.QRCodeType;
import com.project.Shorty.Exception.QRCodeGenerationException;
import com.project.Shorty.Repository.QRCodeMappingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class QRCodeServiceImpl implements QRCodeService{
    private final String format = "png";
    private final QRCodeMappingRepository qrCodeMappingRepository;

    @Override
    public QRCodeResponseDTO generateEAN13BarcodeImage(String longURL) {
        try{

            String customUUID = generateCustomUUID();

            QRCodeEntity qrCodeEntity = new QRCodeEntity();
            qrCodeEntity.setLongURL(longURL);
            qrCodeEntity.setQrCodeType(QRCodeType.ONE_DIMENSIONAL);
            qrCodeEntity.setShortURL(customUUID);
            qrCodeMappingRepository.save(qrCodeEntity);

            EAN13Writer barcodeWriter = new EAN13Writer();
            BitMatrix bitMatrix = barcodeWriter.encode(customUUID, BarcodeFormat.EAN_13, 300, 150);
            byte[] imageData = toByteArray(MatrixToImageWriter.toBufferedImage(bitMatrix), this.format); //Throwing Illegal args exception due to string being more than 13 chars

            File outputfile = new File("QRCode.png");
            ImageIO.write(MatrixToImageWriter.toBufferedImage(bitMatrix), "png", outputfile);

            QRCodeResponseDTO qrCodeResponseDTO = new QRCodeResponseDTO();
            qrCodeResponseDTO.setImageData(imageData);
            qrCodeResponseDTO.setQrCodeType(QRCodeType.ONE_DIMENSIONAL);

            return qrCodeResponseDTO;
        }
        catch (Exception ex){
            throw new QRCodeGenerationException(ex.getMessage());
        }
    }

    @Override
    public QRCodeResponseDTO generateQRCodeImage(String longURL) {
        try{

            String customUUID = generateCustomUUID();

            QRCodeEntity qrCodeEntity = new QRCodeEntity();
            qrCodeEntity.setLongURL(longURL);
            qrCodeEntity.setQrCodeType(QRCodeType.TWO_DIMENSIONAL);
            qrCodeEntity.setShortURL(customUUID);
            qrCodeMappingRepository.save(qrCodeEntity);

            QRCodeWriter barcodeWriter = new QRCodeWriter();
            BitMatrix bitMatrix = barcodeWriter.encode(longURL, BarcodeFormat.QR_CODE, 200, 200);
            byte[] imageData = this.toByteArray(MatrixToImageWriter.toBufferedImage(bitMatrix), this.format);

            File outputfile = new File("QRCode.png");
            ImageIO.write(MatrixToImageWriter.toBufferedImage(bitMatrix), "png", outputfile);

            QRCodeResponseDTO qrCodeResponseDTO = new QRCodeResponseDTO();
            qrCodeResponseDTO.setImageData(imageData);
            qrCodeResponseDTO.setQrCodeType(QRCodeType.TWO_DIMENSIONAL);

            return qrCodeResponseDTO;
        }
        catch (Exception ex){
            throw new QRCodeGenerationException(ex.getMessage());
        }
    }

    private byte[] toByteArray(BufferedImage bufferedImage, String format) {
        try{
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ImageIO.write(bufferedImage, format, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        }
        catch (IOException ex){
            throw new QRCodeGenerationException(ex.getMessage());
        }
    }

    private String generateCustomUUID(){
        byte[] array = new byte[13];
        new Random().nextBytes(array);

        return new String(array, StandardCharsets.UTF_8);
    }
}
