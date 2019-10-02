package com.ezgiozkaya.prototypeApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.ezgiozkaya.prototypeApp.repository.SubscriberRepository;

@SpringBootApplication
@EnableCaching
@EnableScheduling
public class PrototypeAppApplication implements CommandLineRunner {

	@Autowired
	private SubscriberRepository subscriberRepository;

	@Value("${app.path}")
	private String path;

	public static void main(String[] args) {
		SpringApplication.run(PrototypeAppApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {

		subscriberRepository.init(path);

	}

}
