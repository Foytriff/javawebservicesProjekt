package com.example.projekt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;


@Configuration
public class WebClientConfig {
    @Bean(name = "jp")
    public WebClient webClient(){

        return WebClient.builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    };
}
