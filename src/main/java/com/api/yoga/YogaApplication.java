package com.api.yoga;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class YogaApplication {

	public static void main(String[] args) {
		SpringApplication.run(YogaApplication.class, args);
	}

	@GetMapping("/")

	public  String index(){
		return "funcionando";
	}
}
