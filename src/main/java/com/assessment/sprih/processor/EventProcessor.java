package com.assessment.sprih.processor;

import com.assessment.sprih.dto.CallbackRequest;
import com.assessment.sprih.model.Event;
import com.assessment.sprih.model.Status;
import com.assessment.sprih.service.CallbackService;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.concurrent.BlockingQueue;

public abstract class EventProcessor {
    private BlockingQueue<Event> queue;
    private CallbackService callbackService;
    @Getter
    private String name;

    protected EventProcessor(BlockingQueue<Event> queue, CallbackService callbackService, String name){
        this.queue = queue;
        this.callbackService = callbackService;
        this.name = name;
    }

    void process(){
        try {
            if(queue.isEmpty()) return;
            Event event = queue.take();
            boolean failure = Math.random() < 0.1;
            CallbackRequest callbackRequest = failure ? new CallbackRequest(event.getEventId(), Status.FAILED, event.getEventType(), "Simulated processing failure", LocalDateTime.now().toString()) : this.execute(event);
            callbackService.sendRequest(event.getCallbackUrl(), callbackRequest);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public boolean isQueueEmpty(){
        return queue.isEmpty();
    }

    abstract CallbackRequest execute(Event event);
}