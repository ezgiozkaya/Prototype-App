package com.ezgiozkaya.prototypeApp.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ezgiozkaya.prototypeApp.model.Subscriber;
import com.ezgiozkaya.prototypeApp.service.SubscriberService;

@RestController
public class SubscriberRestController {

	private static final Logger log = LogManager.getLogger(SubscriberRestController.class);

	@Autowired
	private SubscriberService subscriberService;

	@GetMapping(value = "getSubscriberById/{id}")
	@ResponseBody
	public ResponseEntity<Subscriber> getSubscriberById(@PathVariable("id") Long id) {
		Subscriber subscriberById = subscriberService.getSubscriberById(id);

		if (subscriberById == null) {
			log.error("/getSubscriberById id = " + id + " not found");
			return new ResponseEntity<Subscriber>(HttpStatus.NOT_FOUND);
		}

		log.info("/getSubscriberById id = " + id);
		return new ResponseEntity<Subscriber>(subscriberById, HttpStatus.OK);
	}

	@GetMapping(value = "getAllSubscribers")
	@ResponseBody
	public ResponseEntity<List<Subscriber>> getAllSubscriber() {
		List<Subscriber> subscribers = subscriberService.getAllSubscribers();
		log.info("/getAllSubscribers");
		return new ResponseEntity<List<Subscriber>>(subscribers, HttpStatus.OK);
	}

	@PostMapping(value = "subscriber")
	public ResponseEntity<Subscriber> createSubscriber(@Valid @RequestBody Subscriber subscriber) {
		Subscriber createdSubscriber = subscriberService.createSubscriber(subscriber);
		log.info("/subscriber[POST] id = " + subscriber.getId() + ", name = " + subscriber.getName() + ", msisdn = "
				+ subscriber.getMsisdn());
		return new ResponseEntity<Subscriber>(createdSubscriber, HttpStatus.OK);
	}

	@PutMapping(value = "subscriber")
	public ResponseEntity<Subscriber> updateSubscriber(@Valid @RequestBody Subscriber subscriber) {
		Subscriber updatedSubscriber = subscriberService.updateSubscriber(subscriber);
		if (updatedSubscriber == null) {
			log.error("/subscriber[PUT] id = " + subscriber.getId() + " not found");
			return new ResponseEntity<Subscriber>(HttpStatus.NOT_FOUND);
		}

		log.info("/subscriber[PUT] id = " + subscriber.getId() + ", name = " + subscriber.getName() + ", msisdn = "
				+ subscriber.getMsisdn());
		return new ResponseEntity<Subscriber>(updatedSubscriber, HttpStatus.OK);
	}

	@DeleteMapping(value = "subscriber/{id}")
	public ResponseEntity<Long> deleteSubscriber(@PathVariable Long id) {
		Long deletedId = subscriberService.deleteSubscriber(id);
		if (deletedId == null) {
			log.error("/subscriber[DELETE] id = " + id + " not found");
			return new ResponseEntity<Long>(HttpStatus.NOT_FOUND);
		}

		log.info("/subscriber[DELETE] id = " + id);
		return new ResponseEntity<Long>(deletedId, HttpStatus.OK);
	}

}
