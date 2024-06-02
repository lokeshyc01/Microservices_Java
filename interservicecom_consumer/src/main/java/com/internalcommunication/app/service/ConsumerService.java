package com.internalcommunication.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

import com.internalcommunication.app.client.ConsumerClient;

@Service
public class ConsumerService {
	@Autowired
	private ConsumerClient client;
	public String getMsg(String name) {
		return client.invokeproducer(name);
	}
}
