package com.assessment.sprih.listener;

import com.assessment.sprih.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.stereotype.Component;

@Component
public class ShutdownListener implements ApplicationListener<ContextClosedEvent> {
    @Autowired
    private EventService eventService;

    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        eventService.stop();
    }
}
