package com.jeanlucas.apirestful.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.jeanlucas.apirestful.domain.User;
import com.jeanlucas.apirestful.repository.UserRepository;

@Configuration
public class TestConfig implements CommandLineRunner {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Maria Silva", "maria@gmail.com");
		User u2 = new User(null, "Jean Lucas", "jean@gmail.com");
		
		userRepository.saveAll(Arrays.asList(u1, u2));
	}
	
}
