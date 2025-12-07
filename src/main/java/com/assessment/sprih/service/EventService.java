package com.assessment.sprih.service;

import com.assessment.sprih.dto.EventRequest;
import com.assessment.sprih.dto.EventResponse;
import com.assessment.sprih.model.Event;
import com.assessment.sprih.processor.EmailProcessor;
import com.assessment.sprih.processor.EventProcessor;
import com.assessment.sprih.processor.EventRunnable;
import com.assessment.sprih.queue.EventQueues;
import com.assessment.sprih.queue.EventThreads;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@Service
public class EventService {

    @Autowired
    private CallbackService callbackService;

    EventThreads eventThreads;
    EventQueues eventQueues;


    public EventService(){
        eventQueues = new EventQueues();
    }

    @PostConstruct
    public void init(){
        eventThreads = new EventThreads(eventQueues, callbackService);
        eventThreads.initialize();
    }

    public EventResponse createEvent(EventRequest request){
//        System.out.println(request);
        String eventId = UUID.randomUUID().toString();
//        emailThread.start();
        Event event = new Event(eventId,request.getEventType(), request.getPayload(), request.getCallbackUrl());
        switch (request.getEventType()){
            case EMAIL -> eventQueues.email.add(event);
            case SMS -> eventQueues.sms.add(event);
            case NOTIFICATION -> eventQueues.notification.add(event);
            default -> System.out.println("Invalid Event Type!");
        }

        String message = "Event accepted for processing.";
        return new EventResponse(eventId, message);
    }

    public void stop(){
         eventThreads.stop();
    }
}
