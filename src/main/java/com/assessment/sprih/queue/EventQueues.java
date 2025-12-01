package com.assessment.sprih.queue;

import com.assessment.sprih.model.Event;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class EventQueues {
    public BlockingQueue<Event> email = new LinkedBlockingQueue<>();
    public BlockingQueue<Event> sms = new LinkedBlockingQueue<>();
    public BlockingQueue<Event> notification = new LinkedBlockingQueue<>();
}
