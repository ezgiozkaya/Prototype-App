package com.ezgiozkaya.prototypeApp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.ezgiozkaya.prototypeApp.model.Subscriber;
import com.ezgiozkaya.prototypeApp.repository.SubscriberRepository;

@Service
public class Schedule {

	@Autowired
	private SubscriberRepository subscriberRepository;

	@Scheduled(cron = "${app.schedule}")
	public void test() {
		System.out.println("Çalıştı");

		List<Subscriber> allSubscribers = subscriberRepository.getAllSubscribers();

		Util.saveSubscribers(subscriberRepository.getPath(), allSubscribers);
	}

}
