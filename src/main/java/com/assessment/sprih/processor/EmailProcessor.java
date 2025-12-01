package com.assessment.sprih.processor;


import com.assessment.sprih.model.Event;

import java.util.concurrent.BlockingQueue;

public class EmailProcessor extends EventProcessor{
    public EmailProcessor(BlockingQueue<Event> queue){
        super(queue);
    }

    @Override
    public void execute() {
        try {
            System.out.println("Event: " + queue.take().getEventId() +" - Email Processing started...");
            Thread.sleep(5000);
            System.out.println("Email Processing done!");
        } catch (InterruptedException e){
           e.printStackTrace();
        }
    }
}
