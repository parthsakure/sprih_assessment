package com.assessment.sprih.processor;

public class EventRunnable implements Runnable{
    private EventProcessor eventProcessor;
    public EventRunnable(EventProcessor eventProcessor){
        this.eventProcessor = eventProcessor;
    }
    @Override
    public void run() {
        eventProcessor.execute();
    }
}
