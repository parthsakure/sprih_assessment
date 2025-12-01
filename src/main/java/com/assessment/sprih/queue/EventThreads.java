package com.assessment.sprih.queue;

import com.assessment.sprih.processor.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EventThreads {
    private Thread email;
    private Thread sms;
    private Thread notification;

    public EventThreads(EventQueues eventQueues){
        this.email = new Thread(new EventRunnable(new EmailProcessor(eventQueues.email)));
        this.sms = new Thread(new EventRunnable(new SMSProcessor(eventQueues.sms)));
        this.notification = new Thread(new EventRunnable(new NotificationProcessor(eventQueues.notification)));
    }

    public void initialize(){
        email.start();
        sms.start();
        notification.start();
    }
}
