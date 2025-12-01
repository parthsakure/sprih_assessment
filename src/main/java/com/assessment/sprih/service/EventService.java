package com.assessment.sprih.service;

import com.assessment.sprih.dto.EventRequest;
import com.assessment.sprih.dto.EventResponse;
import com.assessment.sprih.model.Event;
import com.assessment.sprih.processor.EmailProcessor;
import com.assessment.sprih.processor.EventProcessor;
import com.assessment.sprih.processor.EventRunnable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.LinkedBlockingQueue;

@Service
public class EventService {


    Thread emailThread;
    EventProcessor emailProcessor;


    public EventService(){
        emailProcessor = new EmailProcessor(new LinkedBlockingQueue<>());
        emailThread = new Thread(new EventRunnable(emailProcessor));
        emailThread.start();
    }

    public EventResponse createEvent(EventRequest request){
//        System.out.println(request);
        String eventId = UUID.randomUUID().toString();
        String message = "Event accepted for processing.";
//        emailThread.start();
        Event event = Event.builder()
                .eventId(eventId)
                .payload(request.getPayload())
                .callbackUrl(request.getCallbackUrl())
                .eventType(request.getEventType())
                .build();
        emailProcessor.queue.add(event);

        return EventResponse.builder()
                .eventId(eventId)
                .message(message)
                .build();
    }
}
