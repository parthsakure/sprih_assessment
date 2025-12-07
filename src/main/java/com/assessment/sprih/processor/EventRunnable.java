package com.assessment.sprih.processor;

public class EventRunnable implements Runnable{
    private final EventProcessor eventProcessor;
    private boolean running;
    private String name;
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
        System.out.printf("Thread: %s Terminated.%n", eventProcessor.getName());
    }



    public void stop(){
        running = false;
    }
}
