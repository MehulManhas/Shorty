package com.project.Shorty.Client;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.project.Shorty.Configuration.AWS.AWSConfiguration;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AWSClient {
    private final AWSConfiguration awsConfiguration;
    @Bean
    public AmazonS3 getAWSClient(){
        AmazonS3 s3client = AmazonS3ClientBuilder
                .standard()
                .withCredentials(new AWSStaticCredentialsProvider(awsConfiguration.getAwsCredentials()))
                .withRegion(Regions.US_EAST_2)
                .build();

        return s3client;
    }
}
