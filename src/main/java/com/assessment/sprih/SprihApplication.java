package com.assessment.sprih;

import com.assessment.sprih.listener.ShutdownListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SprihApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(SprihApplication.class);
        app.addListeners(new ShutdownListener());
        app.run(args);

	}

}
