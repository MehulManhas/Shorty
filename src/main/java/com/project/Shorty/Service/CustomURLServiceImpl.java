package com.project.Shorty.Service;

import com.project.Shorty.DTO.*;
import com.project.Shorty.Entity.CustomURLMappingEntity;
import com.project.Shorty.Repository.CustomURLMappingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomURLServiceImpl implements CustomURLService{
    private final CustomURLMappingRepository customURLMappingRepository;
    @Value("${url.domain.name}")
    private String baseUrl;
    @Override
    public CommonApiResponseDto<Object> checkIfAliasExists(CustomURLRequestDTO customURLRequestDTO) {
        boolean aliasExists = customURLMappingRepository.existsByCustomAlias(customURLRequestDTO.getCustomAlias());
        if(aliasExists) {
            return CommonApiResponseDto.builder()
                    .data(aliasExists)
                    .success(true)
                    .httpCode(HttpStatus.OK)
                    .build();
        }
        return null;
    }

    @Override
    public ShortenedURLResponseDTO createCustomURL(CustomURLRequestDTO customURLRequestDTO) {

        CustomURLMappingEntity customURLMappingEntity = new CustomURLMappingEntity();
        customURLMappingEntity.setRequestedURL(customURLRequestDTO.getLongUrl());
        customURLMappingEntity.setCustomAlias(customURLRequestDTO.getCustomAlias());

        customURLMappingRepository.save(customURLMappingEntity);

        ShortenedURLResponseDTO shortenedURLResponseDTO = new ShortenedURLResponseDTO();
        shortenedURLResponseDTO.setShortenedURL(baseUrl + "c/" + customURLMappingEntity.getCustomAlias());

        return shortenedURLResponseDTO;
    }

    @Override
    public LongURLResponseDto getCustomURL(String customShortURL) {

        String[] urlArr = customShortURL.split("/");
        CustomURLMappingEntity customURLMappingEntity = customURLMappingRepository.findCustomURLMappingEntitiesByCustomAlias(urlArr[urlArr.length-1]);
        LongURLResponseDto longURLResponseDTO = new LongURLResponseDto();
        longURLResponseDTO.setLongURL(customURLMappingEntity.getRequestedURL());

        return longURLResponseDTO;
    }

}
