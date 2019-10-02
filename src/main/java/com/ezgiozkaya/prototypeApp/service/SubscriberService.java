package com.ezgiozkaya.prototypeApp.service;

import java.util.List;

import com.ezgiozkaya.prototypeApp.model.Subscriber;

public interface SubscriberService {

	public Subscriber getSubscriberById(Long id);

	public List<Subscriber> getAllSubscribers();

	Subscriber createSubscriber(Subscriber subs);

	Subscriber updateSubscriber(Subscriber subs);

	Long deleteSubscriber(Long id);

}
