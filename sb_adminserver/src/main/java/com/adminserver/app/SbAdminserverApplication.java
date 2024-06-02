package com.adminserver.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
@EnableAdminServer
@SpringBootApplication
public class SbAdminserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbAdminserverApplication.class, args);
	}

}
