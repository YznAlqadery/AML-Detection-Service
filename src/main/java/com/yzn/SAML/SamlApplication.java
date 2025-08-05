package com.yzn.SAML;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SamlApplication {

	public static void main(String[] args) {
		SpringApplication.run(SamlApplication.class, args);
	}

}
