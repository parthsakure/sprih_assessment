package com.assessment.sprih.queue;

import com.assessment.sprih.model.Event;
import org.springframework.stereotype.Component;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@Component
public class EventQueues {
    public final BlockingQueue<Event> email = new LinkedBlockingQueue<>();
    public final BlockingQueue<Event> sms = new LinkedBlockingQueue<>();
    public final BlockingQueue<Event> notification = new LinkedBlockingQueue<>();
}
