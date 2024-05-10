package com.project.Shorty.Service;

import com.project.Shorty.DTO.CommonApiResponseDto;
import com.project.Shorty.Repository.HealthCheckRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class HealthCheckService {

    private final HealthCheckRepository healthCheckRepository;

    public CommonApiResponseDto<Object> fetchHealthCheckStatus(){
        int healthStatus = healthCheckRepository.FetchHealthStatus();

        return  CommonApiResponseDto.builder()
                .data("returned result "+ healthStatus)
                .success(true)
                .httpCode(HttpStatus.OK)
                .build();
    }
}
