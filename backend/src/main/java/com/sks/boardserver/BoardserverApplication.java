package com.sks.boardserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class BoardserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoardserverApplication.class, args);
	}

}
