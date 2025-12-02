package com.assessment.sprih.controller;

import com.assessment.sprih.dto.CallbackRequest;
import com.assessment.sprih.dto.EventRequest;
import com.assessment.sprih.dto.EventResponse;
import com.assessment.sprih.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/events")
public class EventController {
    @Autowired
    EventService eventService;

    @PostMapping
    public EventResponse createEvent(@RequestBody EventRequest request){
        return eventService.createEvent(request);
    }

    @PostMapping("/callback")
    public ResponseEntity<String> callback(@RequestBody CallbackRequest callbackRequest){
        System.out.println(callbackRequest);
        return new ResponseEntity<>("Accepted", HttpHeaders.EMPTY, HttpStatus.OK);
    }
}
