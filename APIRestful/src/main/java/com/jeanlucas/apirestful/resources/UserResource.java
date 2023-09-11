package com.jeanlucas.apirestful.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jeanlucas.apirestful.domain.User;
import com.jeanlucas.apirestful.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	private UserService userService;
	
	//GetMapping
	@RequestMapping(method= RequestMethod.GET)
	public ResponseEntity<List<User>> findAll(){
		/*User maria = new User("1", "Maria Silva", "maria@gmail.com");
		User alex = new User("2", "Alex Souza", "alex@gmail.com");
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(maria, alex));
		return ResponseEntity.ok().body(list);*/
		
		List<User> list = new ArrayList<>();
		list = userService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "{id}")
	public ResponseEntity<User> findById(@PathVariable String id){
		User obj = userService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}

