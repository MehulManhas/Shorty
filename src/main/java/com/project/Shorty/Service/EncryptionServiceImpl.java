package com.project.Shorty.Service;

import com.project.Shorty.DTO.ShortenedURLResponseDTO;
import com.project.Shorty.Entity.URLMappingEntity;
import com.project.Shorty.Enum.EncryptionType;
import com.project.Shorty.Exception.URLHashingException;
import com.project.Shorty.Repository.URLMappingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EncryptionServiceImpl implements EncryptionService {

    private final URLMappingRepository urlMappingRepository;
    @Value("${url.domain.name}")
    private String baseDomain;
    private static int SHORT_URL_CHAR_SIZE = 7;

    @Override
    public ShortenedURLResponseDTO shortenURLWithMD5(String longUrl) throws URLHashingException {
        try{
            String shortUrl = baseDomain + this.generateRandomShortUrl(longUrl);

            URLMappingEntity urlMappingEntity = new URLMappingEntity();
            urlMappingEntity.setShortenedURL(shortUrl);
            urlMappingEntity.setRequestedURL(longUrl);
            urlMappingEntity.setEncodingType(EncryptionType.MD5);
            urlMappingRepository.save(urlMappingEntity);

            ShortenedURLResponseDTO shortenedURLResponseDTO = new ShortenedURLResponseDTO();
            shortenedURLResponseDTO.setShortenedURL(shortUrl);

            return shortenedURLResponseDTO;
        }
        catch(Exception e) {
            throw new URLHashingException(e.toString());
        }
    }

    @Override
    public ShortenedURLResponseDTO shortenURLWithUUID(String longUrl) throws URLHashingException {
        try{
            String shortUrl = baseDomain + UUID.randomUUID();
            URLMappingEntity urlMappingEntity = new URLMappingEntity();
            urlMappingEntity.setRequestedURL(longUrl);
            urlMappingEntity.setShortenedURL(shortUrl);
            urlMappingEntity.setEncodingType(EncryptionType.UUID);
            urlMappingRepository.save(urlMappingEntity);

            ShortenedURLResponseDTO shortenedURLResponseDTO = new ShortenedURLResponseDTO();
            shortenedURLResponseDTO.setShortenedURL(shortUrl);

            return shortenedURLResponseDTO;
        }
        catch(Exception e) {
            throw new URLHashingException(e.toString());
        }
    }

    private String convertURLToMD5Hash(String url){
        try {

            MessageDigest digest = MessageDigest.getInstance("MD5");
            digest.update(url.getBytes());
            byte messageDigest[] = digest.digest();

            StringBuilder hexString = new StringBuilder();
            for (byte b : messageDigest) {
                hexString.append(Integer.toHexString(0xFF & b));
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
    public  String generateRandomShortUrl(String longURL) {
        String hash= this.convertURLToMD5Hash(longURL);
        int numberOfCharsInHash=hash.length();
        int counter=0;
        while(counter < numberOfCharsInHash-SHORT_URL_CHAR_SIZE){
            if(!urlMappingRepository.existsByShortenedURL(hash.substring(counter, counter+SHORT_URL_CHAR_SIZE))){
                return hash.substring(counter, counter+SHORT_URL_CHAR_SIZE);
            }
            counter++;
        }
        return hash.substring(counter, counter+SHORT_URL_CHAR_SIZE);
    }

}
