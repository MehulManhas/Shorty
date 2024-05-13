package com.project.Shorty.Service;

import com.project.Shorty.DTO.BlockedURLRequestDTO;

public interface BlockedURLService {
    public void addBlockedURL(BlockedURLRequestDTO blockedURLRequestDTO);
    public void deleteBlockedURL(BlockedURLRequestDTO blockedURLRequestDTO);
}
