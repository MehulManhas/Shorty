package com.project.Shorty.Service;

import com.project.Shorty.DTO.LongURLResponseDto;
import com.project.Shorty.Entity.URLMappingEntity;
import com.project.Shorty.Repository.URLMappingRepository;
import org.springframework.stereotype.Service;

@Service
public class SearchService {
    URLMappingRepository urlMappingRepository;

    public SearchService(URLMappingRepository urlMappingRepository) {
        this.urlMappingRepository = urlMappingRepository;
    }

    public String getFullURL(String shortenedURL){
        URLMappingEntity fullURL = urlMappingRepository.findAllByShortenedURL(shortenedURL);
        return fullURL.getRequestedURL();
    }
}
