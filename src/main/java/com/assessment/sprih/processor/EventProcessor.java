package com.assessment.sprih.processor;

import com.assessment.sprih.dto.CallbackRequest;
import com.assessment.sprih.model.Event;
import com.assessment.sprih.service.CallbackService;

import java.util.concurrent.BlockingQueue;

public abstract class EventProcessor {
    private BlockingQueue<Event> queue;
    private CallbackService callbackService;

    protected EventProcessor(BlockingQueue<Event> queue, CallbackService callbackService){
        this.queue = queue;
        this.callbackService = callbackService;
    }

    void process(){
        try {
            Event event = queue.take();
            CallbackRequest callbackRequest = this.execute(event);
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