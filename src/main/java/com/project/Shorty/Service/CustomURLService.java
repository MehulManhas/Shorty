package com.project.Shorty.Service;

import com.project.Shorty.DTO.*;

public interface CustomURLService {
    public CommonApiResponseDto<Object> checkIfAliasExists(CustomURLRequestDTO customURLRequestDTO);
    public ShortenedURLResponseDTO createCustomURL(CustomURLRequestDTO customURLRequestDTO);
    public LongURLResponseDto getCustomURL(String shortenedURLRequestDTO);
}
