package com.jeanlucas.apirestful.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jeanlucas.apirestful.domain.Post;
import com.jeanlucas.apirestful.services.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostResources {
	
	@Autowired
	private PostService postService;
	
	@GetMapping
	public ResponseEntity<List<Post>> findAll(){
		List<Post> posts = postService.findAll();
		return ResponseEntity.ok().body(posts);
	}
	
	@GetMapping(value = "{id}")
	public ResponseEntity<Post> findById(@PathVariable String id){
		Post obj = postService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
