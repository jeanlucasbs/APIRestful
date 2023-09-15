package com.jeanlucas.apirestful.dto;

import java.io.Serializable;

import com.jeanlucas.apirestful.domain.User;

public class UserDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String ID;
	private String name;
	private String email;
	
	public UserDTO() {}
	
	public UserDTO(User obj) {
		ID = obj.getID();
		name = obj.getName();
		email = obj.getEmail();
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
