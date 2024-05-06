package com.project.Shorty.Controller;

import com.project.Shorty.DTO.CustomURLRequestDTO;
import com.project.Shorty.DTO.LongURLResponseDto;
import com.project.Shorty.DTO.ShortenedURLRequestDTO;
import com.project.Shorty.DTO.ShortenedURLResponseDTO;
import com.project.Shorty.Repository.CustomURLMappingRepository;
import com.project.Shorty.Service.CustomURLService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class CustomURLController {
    private final CustomURLService customURLService;


    @PostMapping("/customURL")
    public ResponseEntity<ShortenedURLResponseDTO> getCustomURL(@RequestBody CustomURLRequestDTO customURLRequestDTO) {
        try{
            ShortenedURLResponseDTO shortenedURLResponseDTO = customURLService.createCustomURL(customURLRequestDTO);
            return new ResponseEntity<>(shortenedURLResponseDTO, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/c/{shortURL}")
    public ResponseEntity<LongURLResponseDto> getShortenedURL(@PathVariable("shortURL") String shortURL) {
        try{
           LongURLResponseDto longURLResponseDTO = customURLService.getCustomURL(shortURL);
           return new ResponseEntity<>(longURLResponseDTO, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
