package com.rabbitunicasting.app.config;


import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMQConfiguration 
{
	
	@Value("${springbot.rabbitmq.queue}")
	private String queueName;
	
	
	@Value("${springboot.rabbitmq.exchange}")
	private String exchange;
	
	@Value("${springboot.rabbitmq.routingKey}")
	private String routingKey;
	
	
	@Bean
	Queue queue()
	{
		return new Queue(queueName,false);
	}
	
	@Bean
	DirectExchange exchange() {
		return new DirectExchange(exchange);
	}
	
	@Bean
	Binding binding(Queue queue,DirectExchange directExchange)
	{
		return BindingBuilder.bind(queue).to(directExchange).with(routingKey);
	}
	
	@Bean
	public MessageConverter jsonMessageConverter() {
		return new Jackson2JsonMessageConverter();
	}
	
	
	public AmqpTemplate rabbitTemplate(ConnectionFactory connectionFactory)
	{
		final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		
		rabbitTemplate.setMessageConverter(jsonMessageConverter());
		return rabbitTemplate;
	}

}
