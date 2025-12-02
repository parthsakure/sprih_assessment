package com.assessment.sprih.queue;

import com.assessment.sprih.processor.*;
import com.assessment.sprih.service.CallbackService;
import org.springframework.stereotype.Component;

@Component
public class EventThreads {
    private final Thread email;
    private final Thread sms;
    private final Thread notification;

    public EventThreads(EventQueues eventQueues, CallbackService callbackService){
        this.email = new Thread(new EventRunnable(new EmailProcessor(eventQueues.email, callbackService)));
        this.sms = new Thread(new EventRunnable(new SMSProcessor(eventQueues.sms, callbackService)));
        this.notification = new Thread(new EventRunnable(new NotificationProcessor(eventQueues.notification, callbackService)));
    }

    public void initialize(){
        email.start();
        sms.start();
        notification.start();
    }
}
