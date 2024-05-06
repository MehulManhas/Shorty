package com.project.Shorty.Service;

import com.project.Shorty.DTO.LongURLResponseDTO;
import com.project.Shorty.Entity.URLMappingEntity;
import com.project.Shorty.Exception.ShortenedURLNotFoundException;
import com.project.Shorty.Repository.URLMappingRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@Qualifier("searchServiceImpl")
public class SearchServiceImpl implements SearchService{
    URLMappingRepository urlMappingRepository;

    public SearchServiceImpl(URLMappingRepository urlMappingRepository) {
        this.urlMappingRepository = urlMappingRepository;
    }

    public LongURLResponseDTO getLongURL(String shortenedURL){
        Optional<URLMappingEntity> fullURL = urlMappingRepository.findAllByShortenedURL(shortenedURL);

        try{
            if(!fullURL.isPresent()) {
                throw new ShortenedURLNotFoundException("URL not found");
            }
        }
        catch(ShortenedURLNotFoundException shortenedURLNotFoundException){
            log.error(shortenedURLNotFoundException.getMessage());
        }
        LongURLResponseDTO longURLResponseDto = new LongURLResponseDTO();
        longURLResponseDto.setLongURL(fullURL.get().getRequestedURL());

        return longURLResponseDto;
    }
}
