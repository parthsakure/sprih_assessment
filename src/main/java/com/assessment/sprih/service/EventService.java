package com.assessment.sprih.service;

import com.assessment.sprih.dto.EventRequest;
import com.assessment.sprih.dto.EventResponse;
import com.assessment.sprih.model.Event;
import com.assessment.sprih.model.EventType;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    public EventResponse createEvent(EventRequest request){
//        System.out.println(request);
        String eventId = "e123";
        String message = "Event accepted for processing.";
        Event event = Event.builder()
                .eventId(eventId)
                .payload(request.getPayload())
                .callbackUrl(request.getCallbackUrl())
                .eventType(request.getEventType())
                .build();

        return EventResponse.builder()
                .eventId(eventId)
                .message(message)
                .build();
    }
}
