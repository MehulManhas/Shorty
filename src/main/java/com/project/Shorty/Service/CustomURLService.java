package com.project.Shorty.Service;

import com.project.Shorty.DTO.CommonApiResponseDto;
import com.project.Shorty.DTO.CustomURLRequestDTO;
import com.project.Shorty.DTO.LongURLResponseDTO;
import com.project.Shorty.DTO.ShortenedURLResponseDTO;

public interface CustomURLService {
    public CommonApiResponseDto<Object> checkIfAliasExists(CustomURLRequestDTO customURLRequestDTO);
    public ShortenedURLResponseDTO createCustomURL(CustomURLRequestDTO customURLRequestDTO);
    public LongURLResponseDTO getCustomURL(String shortenedURLRequestDTO);
}
