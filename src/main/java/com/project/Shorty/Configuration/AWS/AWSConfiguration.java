package com.project.Shorty.Configuration.AWS;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
@RequiredArgsConstructor
public class AWSConfiguration {

    @Value("${aws.client.key.accessKey}")
    private String accessKey;
    @Value("${aws.client.key.secretAccessKey}")
    private String secretKey;

    public AWSCredentials getAwsCredentials(){
        AWSCredentials awsCredentials = new BasicAWSCredentials(
                accessKey,
                secretKey
        );
        return awsCredentials;
    }

}
