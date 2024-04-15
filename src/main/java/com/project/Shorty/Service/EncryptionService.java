package com.project.Shorty.Service;

import com.project.Shorty.Entity.URLMappingEntity;
import com.project.Shorty.Enum.EncryptionAlgorithm;
import com.project.Shorty.Repository.URLMappingRepository;
import com.project.Shorty.Util.Util;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class EncryptionService {
    private int SHORT_URL_CHAR_SIZE = 7;
    private URLMappingRepository urlMappingRepository;
    @Value("${url.domain.name}")
    private String baseDomain;

    public EncryptionService(URLMappingRepository urlMappingRepository) {
        this.urlMappingRepository = urlMappingRepository;
    }

    public String shortenURLWithMD5(String longUrl) {
        String hash = baseDomain + Util.convertURLToMD5Hash(longUrl);
        URLMappingEntity urlMappingEntity = new URLMappingEntity();
        urlMappingEntity.setShortenedURL(hash);
        urlMappingEntity.setRequestedURL(longUrl);
        urlMappingEntity.setEncodingType(EncryptionAlgorithm.MD5);
        urlMappingRepository.save(urlMappingEntity);

        return hash;
    }
}
