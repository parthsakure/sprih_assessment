package com.assessment.sprih.processor;


import com.assessment.sprih.model.Event;

import java.util.concurrent.BlockingQueue;

public class SMSProcessor extends EventProcessor {
    public SMSProcessor(BlockingQueue<Event> queue) {
        super(queue);
    }

    @Override
    void execute() {
        try {
            System.out.println("Event: " + queue.take().getEventId() +" - SMS Processing started...");
            Thread.sleep(3000);
            System.out.println("SMS Processing done!");
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
