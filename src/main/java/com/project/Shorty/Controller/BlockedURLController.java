package com.project.Shorty.Controller;

import com.project.Shorty.DTO.BaseURLCheckRequestDTO;
import com.project.Shorty.DTO.BaseURLCheckResponseDTO;
import com.project.Shorty.DTO.BlockedURLRequestDTO;
import com.project.Shorty.Service.BaseURLCheckService;
import com.project.Shorty.Service.BlockedURLService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class BlockedURLController {
    private final BaseURLCheckService baseURLCheckService;
    private final BlockedURLService blockedURLService;

    @PostMapping("/checkBaseURL")
    public ResponseEntity<BaseURLCheckResponseDTO> checkBaseURL(@RequestBody BaseURLCheckRequestDTO baseURLCheckRequestDTO){
        try{
            BaseURLCheckResponseDTO baseURLCheckResponseDTO = baseURLCheckService.checkBaseURL(baseURLCheckRequestDTO.getUrl());
            return new ResponseEntity<>(baseURLCheckResponseDTO, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/addBlockedURL")
    public ResponseEntity<Void> addBlockedURL(@RequestBody BlockedURLRequestDTO blockedURLRequestDTO){
        try{
            blockedURLService.addBlockedURL(blockedURLRequestDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/deleteBlockedURL")
    public ResponseEntity<Void> deleteBlockedURL(@RequestBody BlockedURLRequestDTO blockedURLRequestDTO){
        try{
            blockedURLService.deleteBlockedURL(blockedURLRequestDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
