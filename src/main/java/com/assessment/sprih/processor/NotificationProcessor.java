package com.assessment.sprih.processor;

import com.assessment.sprih.dto.CallbackRequest;
import com.assessment.sprih.model.Event;
import com.assessment.sprih.model.Status;
import com.assessment.sprih.service.CallbackService;

import java.time.LocalDateTime;
import java.util.concurrent.BlockingQueue;

public class NotificationProcessor extends EventProcessor{
    public NotificationProcessor(BlockingQueue<Event> queue, CallbackService callbackService) {
        super(queue,callbackService, "Notification");
    }

    @Override
    CallbackRequest execute(Event event) {
        try {
            System.out.println("Event: " + event.getEventId() +" - Notification Processing started...");
            Thread.sleep(2000);
            System.out.println("Notification Processing done!");
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        return new CallbackRequest(event.getEventId(), Status.COMPLETED, event.getEventType(), null, LocalDateTime.now().toString());

    }
}
