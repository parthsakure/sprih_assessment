package com.assessment.sprih.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Event {
    private String eventId;
    private EventType eventType;
    private String callbackUrl;
    private HashMap<String, String> payload;

}
