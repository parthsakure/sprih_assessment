package com.assessment.sprih.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventRequest {
    private String eventType;
    private String callbackUrl;
    private HashMap<String,String> payload;
}
