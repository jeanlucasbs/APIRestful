package com.jeanlucas.apirestful.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jeanlucas.apirestful.domain.Post;
import com.jeanlucas.apirestful.domain.User;
import com.jeanlucas.apirestful.dto.UserDTO;
import com.jeanlucas.apirestful.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	private UserService userService;
	
	//GetMapping
	@RequestMapping(method= RequestMethod.GET)
	public ResponseEntity<List<UserDTO>> findAll(){
		/*User maria = new User("1", "Maria Silva", "maria@gmail.com");
		User alex = new User("2", "Alex Souza", "alex@gmail.com");
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(maria, alex));
		return ResponseEntity.ok().body(list);*/
		
		List<User> list = userService.findAll();
		List<UserDTO> listDTO = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@GetMapping(value = "{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable String id){
		User obj = userService.findById(id);
		UserDTO objDTO = new UserDTO(obj);
		return ResponseEntity.ok().body(objDTO);
	}
	
	@PostMapping
	public ResponseEntity<Void> insertUser(@RequestBody UserDTO objDto){
		User obj = userService.fromDTO(objDto);
		obj = userService.insertUser(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getID()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping(value = "{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable String id){
		userService.deleteUser(id);
		return ResponseEntity.noContent().build();
		
	}
	
	@PutMapping(value = "{id}")
	public ResponseEntity<Void> updateUser(@RequestBody UserDTO objDto, @PathVariable String id){
		User obj = userService.fromDTO(objDto);
		obj.setID(id);
		obj = userService.update(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getID()).toUri();
		return ResponseEntity.created(uri).build();
		
	}
	
	@GetMapping(value = "/{id}/posts")
	public ResponseEntity<List<Post>> findPosts(@PathVariable String id){
		User obj = userService.findById(id);
		return ResponseEntity.ok().body(obj.getPost());
	}
}

