package com.assessment.sprih.queue;

import com.assessment.sprih.processor.EmailProcessor;
import com.assessment.sprih.processor.EventProcessor;
import com.assessment.sprih.processor.EventRunnable;

public class EventThreads {
    private Thread email;
    private Thread sms;
    private Thread notification;

    public EventThreads(EventQueues eventQueues){
        this.email = new Thread(new EventRunnable(new EmailProcessor(eventQueues.email)));
//        this.sms = new Thread(new EventRunnable(new EmailProcessor(eventQueues.email)));
//        this.notification = new Thread(new EventRunnable(new EmailProcessor(eventQueues.email)));
    }

    public void initialize(){
        email.start();
    }
}
