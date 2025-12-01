package com.assessment.sprih.processor;

import com.assessment.sprih.model.Event;

import java.util.concurrent.BlockingQueue;

public abstract class EventProcessor {
    public BlockingQueue<Event> queue;
    abstract void execute();
}