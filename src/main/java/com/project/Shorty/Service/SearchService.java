package com.project.Shorty.Service;


import com.project.Shorty.DTO.LongURLResponseDTO;

public interface SearchService {
    public LongURLResponseDTO getLongURL(String shortenedURL);
}
