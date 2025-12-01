package com.assessment.sprih.service;

import com.assessment.sprih.dto.EventRequest;
import com.assessment.sprih.dto.EventResponse;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    public EventResponse createEvent(EventRequest request){
        System.out.println(request);
        String eventId = "e123";
        String message = "Event accepted for processing.";
        return EventResponse.builder()
                .eventId(eventId)
                .message(message)
                .build();
    }
}
