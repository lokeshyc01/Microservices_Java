package com.inmemory.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception
	{
		auth.inMemoryAuthentication().withUser("lokesh").password("{noop}Lokesh@11").roles("ADMIN");
		auth.inMemoryAuthentication().withUser("mayur").password("{noop}Mayur@11").roles ("STUDENT");
		
	}
	
	@Bean
	public SecurityFilterChain configure(HttpSecurity http) throws Exception{


        http.authorizeHttpRequests(req ->
                req.requestMatchers("/home").permitAll()
                        .requestMatchers("/test").hasRole("ADMIN")
                        .requestMatchers("/student").hasRole("STUDENT")
        )
        .formLogin(withDefaults())
        .httpBasic(withDefaults());
        
        return http.build();
	
	}
}
