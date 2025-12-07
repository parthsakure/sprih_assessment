package com.assessment.sprih.queue;

import com.assessment.sprih.processor.*;
import com.assessment.sprih.service.CallbackService;
import org.springframework.stereotype.Component;

@Component
public class EventThreads {
    private final Thread email;
    private final Thread sms;
    private final Thread notification;
    private final EventRunnable emailRunnable;
    private final EventRunnable smsRunnable;
    private final EventRunnable notificationRunnable;

    public EventThreads(EventQueues eventQueues, CallbackService callbackService){
        emailRunnable = new EventRunnable(new EmailProcessor(eventQueues.email, callbackService));
        this.email = new Thread(emailRunnable);

        smsRunnable = new EventRunnable(new SMSProcessor(eventQueues.sms, callbackService));
        this.sms = new Thread(smsRunnable);

        notificationRunnable = new EventRunnable(new NotificationProcessor(eventQueues.notification, callbackService));
        this.notification = new Thread(notificationRunnable);
    }

    public void initialize(){
        email.start();
        sms.start();
        notification.start();
    }

    public void stop(){
        emailRunnable.stop();
        smsRunnable.stop();
        notificationRunnable.stop();
    }
}
