package com.project.Shorty.Service;

import com.project.Shorty.DTO.BlockedURLRequestDTO;
import com.project.Shorty.Entity.BlockedURLEntity;
import com.project.Shorty.Exception.EntitySaveException;
import com.project.Shorty.Repository.BlockedURLRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BlockedURLServiceImpl implements BlockedURLService{
    private final BlockedURLRepository blockedURLRepository;
    @Override
    public void addBlockedURL(BlockedURLRequestDTO blockedURLRequestDTO) {
        try{
            BlockedURLEntity blockedURLEntity = new BlockedURLEntity();
            blockedURLEntity.setUrl(blockedURLRequestDTO.getBlockedURL());
            blockedURLRepository.save(blockedURLEntity);

        }
        catch (Exception e){
            throw new EntitySaveException(e.getMessage());
        }
    }

    @Override
    public void deleteBlockedURL(BlockedURLRequestDTO blockedURLRequestDTO) {
        try{
            blockedURLRepository.delete(blockedURLRepository.findByUrlLike(blockedURLRequestDTO.getBlockedURL()));
        }
        catch (Exception e){
            throw new EntitySaveException(e.getMessage());
        }
    }
}
