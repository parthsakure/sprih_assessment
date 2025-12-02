package com.assessment.sprih.processor;


import com.assessment.sprih.dto.CallbackRequest;
import com.assessment.sprih.model.Event;
import com.assessment.sprih.model.Status;
import com.assessment.sprih.service.CallbackService;

import java.time.LocalDateTime;
import java.util.concurrent.BlockingQueue;

public class EmailProcessor extends EventProcessor{
    public EmailProcessor(BlockingQueue<Event> queue, CallbackService callbackService){
        super(queue, callbackService);
    }

    @Override
    public CallbackRequest execute(Event event) {
        try {
            System.out.println("Event: " + event.getEventId() +" - Email Processing started...");
            Thread.sleep(5000);
            System.out.println("Email Processing done!");
        } catch (InterruptedException e){
           e.printStackTrace();
        }
        return new CallbackRequest(event.getEventId(), Status.COMPLETED, event.getEventType(), null, LocalDateTime.now().toString());

    }
}
