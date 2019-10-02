package com.ezgiozkaya.prototypeApp.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ezgiozkaya.prototypeApp.Util;
import com.ezgiozkaya.prototypeApp.model.Subscriber;

@Repository
public class SubscriberRepository {

	private String dataPath;

	public String getPath() {
		return dataPath;
	}

	private List<Subscriber> subscribers;

	public SubscriberRepository() {

	}

	public void init(String path) {
		dataPath = path;

		subscribers = Util.getSubscribersFromJson(dataPath);
	}

	public List<Subscriber> getAllSubscribers() {
		return subscribers;
	}

	public Subscriber findSubscriberById(Long id) {
		for (Subscriber subscriber : subscribers) {
			if (subscriber.getId() == id) {
				return subscriber;
			}
		}
		return null;
	}

	public Subscriber addSubscriber(Subscriber subscriber) {
		subscribers.add(subscriber);
		return subscriber;
	}

	public Subscriber updateSubscriber(Subscriber subscriber) {
		for (Subscriber subs : subscribers) {
			if (subs.getId() == subscriber.getId()) {
				subs.setName(subscriber.getName());
				subs.setMsisdn(subscriber.getMsisdn());
				return subs;
			}
		}
		return null;
	}

	public Long deleteSubscriber(Long id) {
		for (Subscriber subscriber : subscribers) {
			if (subscriber.getId() == id) {
				subscribers.remove(subscriber);
				return id;
			}
		}
		return null;
	}

}
