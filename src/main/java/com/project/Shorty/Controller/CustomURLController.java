package com.project.Shorty.Controller;

import com.project.Shorty.DTO.CustomURLRequestDTO;
import com.project.Shorty.DTO.LongURLResponseDTO;
import com.project.Shorty.DTO.ShortenedURLResponseDTO;
import com.project.Shorty.Service.CustomURLService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

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
    public ResponseEntity<Void> getLongURL(@PathVariable("shortURL") String shortURL) {
        try{
            LongURLResponseDTO longURLResponseDTO = customURLService.getCustomURL(shortURL);
           return ResponseEntity.status(HttpStatus.FOUND)
                   .location(new URI(longURLResponseDTO.getLongURL()))
                   .build();
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
