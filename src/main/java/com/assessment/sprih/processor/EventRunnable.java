package com.assessment.sprih.processor;

public class EventRunnable implements Runnable{
    private EventProcessor eventProcessor;
    public EventRunnable(EventProcessor eventProcessor){
        this.eventProcessor = eventProcessor;
    }
    @Override
    public void run() {
        while (true){
            if(!eventProcessor.isQueueEmpty())
                eventProcessor.process();
//            Thread.sleep(100);
        }
    }
}
