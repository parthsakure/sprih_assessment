package com.assessment.sprih.processor;

public class EventRunnable implements Runnable{
    private EventProcessor eventProcessor;
    private boolean running;
    public EventRunnable(EventProcessor eventProcessor){
        this.eventProcessor = eventProcessor;
        running = true;
    }
    @Override
    public void run() {
        while (running || !eventProcessor.isQueueEmpty()){
                eventProcessor.process();
//            Thread.sleep(100);
        }
    }

    public void stop(){
        running = false;
    }
}
