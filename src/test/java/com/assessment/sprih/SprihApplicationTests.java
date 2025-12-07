package com.assessment.sprih;

import com.assessment.sprih.dto.EventRequest;
import com.assessment.sprih.dto.EventResponse;
import com.assessment.sprih.model.EventType;
import com.assessment.sprih.service.EventService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.test.util.AssertionErrors.assertNotNull;

@SpringBootTest
class SprihApplicationTests {

    @Autowired private EventService eventService;

	@Test
	void serviceCreationTest() {
        HashMap<String, String>payload = new HashMap<>();
        payload.put("recipient", "test@test.com");
        payload.put("message", "this is test message");

        EventRequest eventRequest = new EventRequest(
                EventType.EMAIL, "https://localhost:8080/api/events/callback",payload);
            EventResponse eventResponse = eventService.createEvent(eventRequest);
            assertNotNull("Event Service verified", eventResponse);
    }

}
