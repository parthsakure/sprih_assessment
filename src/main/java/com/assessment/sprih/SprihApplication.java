package com.assessment.sprih;

//import com.assessment.sprih.listener.ShutdownListener;
import com.assessment.sprih.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SprihApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(SprihApplication.class);
        app.run(args);
//        app.addListeners(new ShutdownListener());
	}

}
