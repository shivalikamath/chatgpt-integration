package com.github.chatgptsample.chatgptsample.config;

import feign.Logger;
import feign.Request;
import feign.RequestInterceptor;
import feign.Retryer;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Indexed;

@Configuration
@ConfigurationProperties(prefix = "openai")
@Indexed
@Data
public class ChatGPTClientConfig {

    @Value("${openai.http-client.readTimeout}")
    private int readTimeout;

    @Value("${openai.http-client.connectTimeout}")
    private int connectTimeout;

    @Value("${openai.apiKey}")
    private String apiKey;

    @Value("${openai.gptModel}")
    private String model;

    @Bean
    public Request.Options options() {
        return new Request.Options(getConnectTimeout(), getReadTimeout());
    }

    @Bean
    public Logger.Level feignLogger() {
        return Logger.Level.FULL;
    }

    @Bean
    public Retryer retryer() {
        return new Retryer.Default();
    }

    @Bean
    public RequestInterceptor apiKeyInterceptor() {
        return request -> request.header("Authorization", "Bearer " + apiKey);
    }
}