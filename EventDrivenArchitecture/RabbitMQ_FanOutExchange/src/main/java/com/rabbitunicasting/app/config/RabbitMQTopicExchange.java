package com.rabbitunicasting.app.config;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQTopicExchange {

	@Bean
	Queue financeQueue() {
		return new Queue("financeQueue",false);
	}
	
	@Bean
	Queue marketingQueue() {
		return new Queue("marketingQueue",false);
	}
	
	@Bean
	Queue adminQueue() {
		return new Queue("adminQueue",false);
	}
	
	@Bean
	FanoutExchange exchange() {
		return new FanoutExchange("fanout-exchange");
	}
	
	@Bean
	Binding financeBinding(FanoutExchange exchange,Queue financeQueue) {
		return BindingBuilder.bind(financeQueue).to(exchange);
	}
	
	@Bean
	Binding marketingBinding(FanoutExchange exchange,Queue marketingQueue) {
		return BindingBuilder.bind(marketingQueue).to(exchange);
	}
	
	@Bean
	Binding hrBinding(FanoutExchange exchange,Queue adminQueue) {
		return BindingBuilder.bind(adminQueue).to(exchange);
	}

	
	@Bean
	public MessageConverter jsonMessageConverter() {
	return new Jackson2JsonMessageConverter();
}
	
//	@Bean
//	MessageListenerContainer messageListenerContainer(ConnectionFactory connection) {
//		SimpleMessageListenerContainer simpleMessageListenerContainer = new SimpleMessageListenerContainer();
//		simpleMessageListenerContainer.setConnectionFactory(connection);
//		return simpleMessageListenerContainer;
//		
//	}
	
	AmqpTemplate rabbitTemplate(ConnectionFactory connection) {
		RabbitTemplate rabbitTemplate = new RabbitTemplate(connection);
		rabbitTemplate.setMessageConverter(jsonMessageConverter());
		return rabbitTemplate;
	}
}
