package com.jeanlucas.apirestful.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeanlucas.apirestful.domain.Post;
import com.jeanlucas.apirestful.repository.PostRepository;

@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepository;
	
	public List<Post> findAll(){
		return postRepository.findAll();
	}
	
	public Post findById(String id){
		Optional<Post> obj = postRepository.findById(id);
		return obj.get();
	}
}
