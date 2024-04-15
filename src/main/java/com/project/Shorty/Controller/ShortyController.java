package com.project.Shorty.Controller;

import com.project.Shorty.DTO.LongURLResponseDto;
import com.project.Shorty.DTO.ShortenedURLRequestDTO;
import com.project.Shorty.DTO.ShortenedURLResponseDTO;
import com.project.Shorty.Service.EncryptionService;
import com.project.Shorty.Service.SearchService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/shortify")
public class ShortyController {

    private EncryptionService encryptionService;
    private SearchService searchService;
    @Value("${url.domain.name}")
    private String baseUrl;
    public ShortyController(EncryptionService encryptionService, SearchService searchService) {
        this.encryptionService = encryptionService;
        this.searchService = searchService;
    }

    @PostMapping("/MD5")
    public ResponseEntity<ShortenedURLResponseDTO> generateShortenedURL(@RequestBody ShortenedURLRequestDTO shortenedURLRequestDTO){
        String shortenedURL = encryptionService.shortenURLWithMD5(shortenedURLRequestDTO.getRequestedURL());
        ShortenedURLResponseDTO shortenedURLResponseDTO = new ShortenedURLResponseDTO();
        shortenedURLResponseDTO.setShortenedURL(shortenedURL);
        return new ResponseEntity<>(shortenedURLResponseDTO, HttpStatus.OK);
    }

    @GetMapping("/{shortenedHash}")
    public ResponseEntity<LongURLResponseDto> getFullURL(@PathVariable("shortenedHash") String hash){
        String shortenedUrl = baseUrl + hash;
        String fullURL = searchService.getFullURL(shortenedUrl);
        LongURLResponseDto longURLResponseDto = new LongURLResponseDto();
        longURLResponseDto.setLongURL(fullURL);
        return new ResponseEntity<>(longURLResponseDto, HttpStatus.OK);
    }
}
