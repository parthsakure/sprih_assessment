package com.assessment.sprih.processor;

import com.assessment.sprih.model.Event;

import java.util.concurrent.BlockingQueue;

public class NotificationProcessor extends EventProcessor{
    public NotificationProcessor(BlockingQueue<Event> queue) {
        super(queue);
    }

    @Override
    void execute() {
        try {
            System.out.println("Event: " + queue.take().getEventId() +" - Notification Processing started...");
            Thread.sleep(2000);
            System.out.println("Notification Processing done!");
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
