package com.example.logger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	Logger logger = LoggerFactory.getLogger(Controller.class);
	@GetMapping("/test")
	public String hello() {
		logger.trace("A trace message");
		logger.debug("A debug message");
		logger.error("A error message");
		logger.info("A info message");
		logger.warn("A warn message");
		return "Hello!";
	}
}
