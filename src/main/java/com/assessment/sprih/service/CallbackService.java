package com.assessment.sprih.service;

import com.assessment.sprih.dto.CallbackRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CallbackService {

    private final RestTemplate restTemplate = new RestTemplate();



    public void sendRequest(String callbackUrl, CallbackRequest callbackRequest){
        try {
            String response = this.restTemplate.postForObject(callbackUrl, callbackRequest, String.class);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
