package com.fitness.activityservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientException;
import org.springframework.web.reactive.function.client.WebClientRequestException;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@Service
@RequiredArgsConstructor

public class UserValidationService {

    private final WebClient userValidationWebClient;

    public Boolean validateUser(String userId){
       try{
           return userValidationWebClient.
                   get()
                   .uri("/api/users/{userId}/validate",userId)
                   .retrieve()
                   .bodyToMono(Boolean.class)
                   .block();
       }catch (WebClientResponseException e){
           if(e.getStatusCode()== HttpStatus.NOT_FOUND){
               throw new RuntimeException("User not found");
           }
           else if(e.getStatusCode()== HttpStatus.UNAUTHORIZED){
               throw new RuntimeException("Unauthorized");
           }
           else{
               throw new RuntimeException(e.getResponseBodyAsString());
           }
       }
    }

}
