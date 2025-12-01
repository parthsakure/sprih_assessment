package com.assessment.sprih.processor;

public class EventRunnable implements Runnable{
    private EventProcessor eventProcessor;
    public EventRunnable(EventProcessor eventProcessor){
        this.eventProcessor = eventProcessor;
    }
    @Override
    public void run() {
        while (true){
            if(!eventProcessor.queue.isEmpty())
                eventProcessor.execute();
//            Thread.sleep(100);
        }
    }
}
