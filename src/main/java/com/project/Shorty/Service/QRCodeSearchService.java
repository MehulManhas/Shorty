package com.project.Shorty.Service;

import com.project.Shorty.DTO.LongURLResponseDTO;
import com.project.Shorty.Entity.QRCodeEntity;
import com.project.Shorty.Repository.QRCodeMappingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QRCodeSearchService implements SearchService{
    private final QRCodeMappingRepository qrCodeMappingRepository;

    @Override
    public LongURLResponseDTO getLongURL(String shortenedURL) {

        QRCodeEntity qrCodeEntity = qrCodeMappingRepository.findByShortURL(shortenedURL);
        LongURLResponseDTO longURLResponseDTO = new LongURLResponseDTO();
        longURLResponseDTO.setLongURL(qrCodeEntity.getLongURL());

        return longURLResponseDTO;
    }
}
