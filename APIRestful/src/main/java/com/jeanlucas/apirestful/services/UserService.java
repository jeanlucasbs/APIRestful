package com.jeanlucas.apirestful.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeanlucas.apirestful.domain.User;
import com.jeanlucas.apirestful.dto.UserDTO;
import com.jeanlucas.apirestful.repository.UserRepository;
import com.jeanlucas.apirestful.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(String id) {
		Optional<User> obj = repository.findById(id);
		return obj.get();
	}
	
	public User insertUser(User user) {
		return repository.insert(user);
	}
	
	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getID(), objDto.getName(), objDto.getEmail());
	}
	
	public void deleteUser(String id) {
		findById(id);
		
		if (id == null) {
			throw new ObjectNotFoundException();
		}
		repository.deleteById(id);
	}
	
	public User updateData(User newObj, User obj) {
		newObj.setEmail(obj.getEmail());
		newObj.setName(obj.getName());
		return newObj;
	}
	
	public User update(User obj) {
		User newObj = findById(obj.getID());
		updateData(newObj, obj);
		return repository.save(newObj); 
	}
}
