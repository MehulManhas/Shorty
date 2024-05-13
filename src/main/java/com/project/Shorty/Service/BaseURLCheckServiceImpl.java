package com.project.Shorty.Service;

import com.amazonaws.services.wafv2.model.Regex;
import com.project.Shorty.DTO.BaseURLCheckResponseDTO;
import com.project.Shorty.Repository.BlockedURLRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RequiredArgsConstructor
@Service
public class BaseURLCheckServiceImpl implements BaseURLCheckService{
    private final BlockedURLRepository blockedURLRepository;
    @Override
    public BaseURLCheckResponseDTO checkBaseURL(String url) {
        Pattern pattern = Pattern.compile("[https://][\\w\\W]*[/]");
        Matcher matcher = pattern.matcher(url);
        //Regex regex = new Regex().withRegexString("[https://][\\w\\W]*.com[/]");
        String currentURL;
        BaseURLCheckResponseDTO baseURLCheckResponseDTO = new BaseURLCheckResponseDTO();
        if(matcher.find()) {
           currentURL = matcher.group(0);
        }
        else{
            baseURLCheckResponseDTO.setMessage("Invalid URL");
            return baseURLCheckResponseDTO;
        }

        if(blockedURLRepository.existsByUrlLike(currentURL)){
            baseURLCheckResponseDTO.setBlocked(true);
            baseURLCheckResponseDTO.setMessage("Blocked URL");
        }

        baseURLCheckResponseDTO.setMessage("Valid URL");
        return baseURLCheckResponseDTO;
    }
}
