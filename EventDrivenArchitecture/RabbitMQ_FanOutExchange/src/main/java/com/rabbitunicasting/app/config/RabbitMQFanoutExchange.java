//package com.rabbitunicasting.app.config;
//
//import org.springframework.amqp.core.AmqpTemplate;
//import org.springframework.amqp.core.Binding;
//import org.springframework.amqp.core.BindingBuilder;
//import org.springframework.amqp.core.DirectExchange;
//import org.springframework.amqp.core.FanoutExchange;
//import org.springframework.amqp.core.Queue;
//import org.springframework.amqp.core.TopicExchange;
//import org.springframework.amqp.rabbit.connection.ConnectionFactory;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
//import org.springframework.amqp.support.converter.MessageConverter;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class RabbitMQFanoutExchange {
//
//	@Bean
//	Queue financeQueue() {
//		return new Queue("financeQueue",false);
//	}
//	
//	@Bean
//	Queue marketingQueue() {
//		return new Queue("marketingQueue",false);
//	}
//	
//	@Bean
//	Queue adminQueue() {
//		return new Queue("adminQueue",false);
//	}
//	
//	@Bean
//	Queue multicastQueue() {
//		return new Queue("multicastQueue",false);
//	}
//	
//	@Bean
//	TopicExchange exchange() {
//		return new TopicExchange("topic-exchange");
//	}
//	
//	@Bean
//	Binding financeBinding(TopicExchange exchange,Queue financeQueue) {
//		return BindingBuilder.bind(financeQueue).to(exchange).with("queue.finance");
//	}
//	
//	@Bean
//	Binding marketingBinding(TopicExchange exchange,Queue marketingQueue) {
//		return BindingBuilder.bind(marketingQueue).to(exchange).with("queue.marketing");
//	}
//	
//	@Bean
//	Binding adminBinding(TopicExchange exchange,Queue adminQueue) {
//		return BindingBuilder.bind(adminQueue).to(exchange).with("queue.admin");
//	}
//	
//	@Bean
//	Binding multicastBinding(TopicExchange exchange,Queue multicastQueue) {
//		return BindingBuilder.bind(multicastQueue).to(exchange).with("queue.*");
//	}
//	
//	@Bean
//	public MessageConverter jsonMessageConverter() {
//	return new Jackson2JsonMessageConverter();
//}
//	
////	@Bean
////	MessageListenerContainer messageListenerContainer(ConnectionFactory connection) {
////		SimpleMessageListenerContainer simpleMessageListenerContainer = new SimpleMessageListenerContainer();
////		simpleMessageListenerContainer.setConnectionFactory(connection);
////		return simpleMessageListenerContainer;
////		
////	}
//	
//	AmqpTemplate rabbitTemplate(ConnectionFactory connection) {
//		RabbitTemplate rabbitTemplate = new RabbitTemplate(connection);
//		rabbitTemplate.setMessageConverter(jsonMessageConverter());
//		return rabbitTemplate;
//	}
//}
