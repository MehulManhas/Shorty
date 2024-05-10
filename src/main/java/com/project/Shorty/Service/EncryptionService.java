package com.project.Shorty.Service;

import com.project.Shorty.DTO.ShortenedURLResponseDTO;
import com.project.Shorty.Exception.URLHashingException;

public interface EncryptionService {
    public ShortenedURLResponseDTO shortenURLWithMD5(String longUrl) throws URLHashingException;
    public ShortenedURLResponseDTO shortenURLWithUUID(String longUrl) throws URLHashingException;

}
