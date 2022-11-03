package com.ragbecca.ITVitaeManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class ItVitaeManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItVitaeManagementApplication.class, args);
	}

}
