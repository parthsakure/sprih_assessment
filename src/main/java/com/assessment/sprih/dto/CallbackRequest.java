package com.assessment.sprih.dto;

import com.assessment.sprih.model.EventType;
import com.assessment.sprih.model.Status;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CallbackRequest {
    private String eventId;
    private Status status;
    private EventType eventType;
    private String errorMessage;
    private String processedAt;
}
