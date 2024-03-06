package com.project.Shorty.Controller;


import com.project.Shorty.DTO.CommonApiResponseDto;
import com.project.Shorty.Service.HealthCheckService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HealthCheckController {

    private final HealthCheckService healthCheckService;

    @GetMapping("/health/check")
    public CommonApiResponseDto<Object> healthCheck(){
        return healthCheckService.fetchHealthCheckStatus();
    }
}
