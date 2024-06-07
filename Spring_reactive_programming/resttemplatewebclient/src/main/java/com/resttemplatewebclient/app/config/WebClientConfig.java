package com.resttemplatewebclient.app.config;

import java.time.Duration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.netty.http.client.HttpClient;

@Configuration
public class WebClientConfig {

	@Bean
	public WebClient getClient() {
		HttpClient httpClient = HttpClient.create()
		        .resolver(spec -> spec.queryTimeout(Duration.ofSeconds(10)));
		WebClient webClient = WebClient.builder()
								.clientConnector(new ReactorClientHttpConnector(httpClient))
								.baseUrl("https://jsonplaceholder.typicode.com/")
								.build();
		return webClient;
	}
}
