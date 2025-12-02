package com.assessment.sprih.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Event {
    private String eventId;
    private EventType eventType;
    private HashMap<String, String> payload;
    private String callbackUrl;

}
