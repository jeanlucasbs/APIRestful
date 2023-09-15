package com.jeanlucas.apirestful.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.jeanlucas.apirestful.domain.Post;
import com.jeanlucas.apirestful.domain.User;
import com.jeanlucas.apirestful.dto.AuthorDTO;
import com.jeanlucas.apirestful.dto.CommentsDTO;
import com.jeanlucas.apirestful.repository.PostRepository;
import com.jeanlucas.apirestful.repository.UserRepository;

@Configuration
public class TestConfig implements CommandLineRunner {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User u1 = new User(null, "Maria Silva", "maria@gmail.com");
		User u2 = new User(null, "Jean Lucas", "jean@gmail.com");
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		
		Post p1 = new Post(null, sdf.parse("13/09/2023"), "Partiu Viagem", "Vou viajar para São Paulo. Abraços", new AuthorDTO(u1));
		Post p2 = new Post(null, sdf.parse("13/09/2023"), "Bom dia", "Acordei feliz hoje", new AuthorDTO(u1));
		
		CommentsDTO c1 = new CommentsDTO("Boa viagem mano", sdf.parse("14/09/2023"), new AuthorDTO(u2));
		CommentsDTO c2 = new CommentsDTO("Aproveite", sdf.parse("14/09/2023"), new AuthorDTO(u2));
		
		p1.getComments().addAll(Arrays.asList(c1, c2));
		
		postRepository.saveAll(Arrays.asList(p1, p2));
		
		u1.getPost().addAll(Arrays.asList(p1, p2));
		userRepository.save(u1);
	}
	
}
