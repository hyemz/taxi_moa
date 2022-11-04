package com.lottenc.taximoa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class TaximoaApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaximoaApplication.class, args);
	}

}
