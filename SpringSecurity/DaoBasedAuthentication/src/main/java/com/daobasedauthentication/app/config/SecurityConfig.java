package com.daobasedauthentication.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.daobasedauthentication.app.service.CustomUserDetailsService;

import static org.springframework.security.config.Customizer.withDefaults;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

	Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	private CustomUserDetailsService userDetailsService;

	@Autowired
	private PasswordEncoder encoder;

//	populated authorization object
	@Bean
	public SecurityFilterChain configure(HttpSecurity http) throws Exception {

		log.info("inside filter chain");
		http.csrf(c -> c.disable())  //need to be configured if not post request from postman will remail unauthorized

				.authorizeHttpRequests(req -> req.requestMatchers("/home").permitAll().requestMatchers("/test")
						.hasRole("ADMIN").requestMatchers("/student").hasRole("STUDENT").anyRequest().authenticated())

				.httpBasic(withDefaults());

		return http.build();

	}

//	populated authentcation object
	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(encoder);
	}

}
