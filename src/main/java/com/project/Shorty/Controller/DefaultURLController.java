package com.project.Shorty.Controller;

import com.project.Shorty.DTO.LongURLResponseDTO;
import com.project.Shorty.DTO.ShortenedURLRequestDTO;
import com.project.Shorty.DTO.ShortenedURLResponseDTO;
import com.project.Shorty.Exception.URLHashingException;
import com.project.Shorty.Service.EncryptionService;
import com.project.Shorty.Service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class DefaultURLController {

    private final EncryptionService encryptionService;

    private final SearchService searchService;
    @Value("${url.domain.name}")
    private String baseUrl;

    @Autowired
    public DefaultURLController(EncryptionService encryptionService, @Qualifier("searchServiceImpl") SearchService searchService) {
        this.encryptionService = encryptionService;
        this.searchService = searchService;
    }

    @PostMapping("/MD5")
    public ResponseEntity<ShortenedURLResponseDTO> generateShortenedURLWithMD5(@RequestBody ShortenedURLRequestDTO shortenedURLRequestDTO){
        try{
            ShortenedURLResponseDTO shortenedURLResponseDTO = encryptionService.shortenURLWithMD5(shortenedURLRequestDTO.getRequestedURL());

            return new ResponseEntity<>(shortenedURLResponseDTO, HttpStatus.OK);
        }
        catch (URLHashingException e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/UUID")
    public ResponseEntity<ShortenedURLResponseDTO> generateShortenedURLWithUUID(@RequestBody ShortenedURLRequestDTO shortenedURLRequestDTO){
        try{
            ShortenedURLResponseDTO shortenedURLResponseDTO = encryptionService.shortenURLWithUUID(shortenedURLRequestDTO.getRequestedURL());

            return new ResponseEntity<>(shortenedURLResponseDTO, HttpStatus.OK);
        }
        catch (URLHashingException urlHashingException){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{shortenedHash}")
    public ResponseEntity<LongURLResponseDTO> getFullURL(@PathVariable("shortenedHash") String shortenedHash) {
        try{
            String shortenedUrl = baseUrl + shortenedHash;
            LongURLResponseDTO longURLResponseDto = searchService.getLongURL(shortenedUrl);
            return new ResponseEntity<>(longURLResponseDto, HttpStatus.OK);
        }
        catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
}
