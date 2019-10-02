package com.ezgiozkaya.prototypeApp.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.ezgiozkaya.prototypeApp.model.Subscriber;
import com.ezgiozkaya.prototypeApp.service.SubscriberService;

import ezgiozkaya.subscriber.GetAllSubscribersResponse;
import ezgiozkaya.subscriber.GetSubscriberByIdRequest;
import ezgiozkaya.subscriber.GetSubscriberByIdResponse;

@Endpoint
public class SubscriberSoapEndPoint {

	private static final String NAMESPACE_URI = "http://www.ezgiozkaya/subscriber";

	private static final Logger log = LogManager.getLogger(SubscriberSoapEndPoint.class);

	@Autowired
	private SubscriberService subscriberService;

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getSubscriberByIdRequest")
	@ResponsePayload
	public GetSubscriberByIdResponse getSubscriberById(@RequestPayload GetSubscriberByIdRequest request) {
		GetSubscriberByIdResponse response = new GetSubscriberByIdResponse();

		Subscriber subscriber = subscriberService.getSubscriberById(request.getId());
		if (subscriber != null) {
			ezgiozkaya.subscriber.Subscriber soapSubscriber = new ezgiozkaya.subscriber.Subscriber();
			soapSubscriber.setId(subscriber.getId());
			soapSubscriber.setName(subscriber.getName());
			soapSubscriber.setMsisdn(subscriber.getMsisdn());

			response.setSubscriber(soapSubscriber);
			log.info("/getSubscriberById id = " + request.getId());
			return response;
		}

		log.error("/getSubscriberById id = " + request.getId() + " not found");
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllSubscribersRequest")
	@ResponsePayload
	public GetAllSubscribersResponse getAllSubscribers() {

		GetAllSubscribersResponse response = new GetAllSubscribersResponse();
		log.info("/getAllSubscribers");

		List<ezgiozkaya.subscriber.Subscriber> subscriberList = new ArrayList<>();
		List<Subscriber> subscribers = subscriberService.getAllSubscribers();

		for (int i = 0; i < subscribers.size(); i++) {
			ezgiozkaya.subscriber.Subscriber sub = new ezgiozkaya.subscriber.Subscriber();
			BeanUtils.copyProperties(subscribers.get(i), sub);
			subscriberList.add(sub);
		}

		response.getSubscriber().addAll(subscriberList);

		return response;
	}

}
