package com.ezgiozkaya.prototypeApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.ezgiozkaya.prototypeApp.model.Subscriber;
import com.ezgiozkaya.prototypeApp.repository.SubscriberRepository;

@Service
public class SubscriberServiceImpl implements SubscriberService {

	@Autowired
	private SubscriberRepository subscriberRepository;

	@Cacheable(value = "subscribers")
	public Subscriber getSubscriberById(Long id) {
		return subscriberRepository.findSubscriberById(id);
	}

	@Cacheable(value = "subscribers")
	public List<Subscriber> getAllSubscribers() {
		return subscriberRepository.getAllSubscribers();
	}

	@CachePut(value = "subscribers")
	public Subscriber createSubscriber(Subscriber subscriber) {
		return subscriberRepository.addSubscriber(subscriber);

	}

	@CachePut(value = "subscribers")
	public Subscriber updateSubscriber(Subscriber subscriber) {

		return subscriberRepository.updateSubscriber(subscriber);
	}

	@CacheEvict(value = "subscribers")
	public Long deleteSubscriber(Long id) {
		return subscriberRepository.deleteSubscriber(id);
	}

}
