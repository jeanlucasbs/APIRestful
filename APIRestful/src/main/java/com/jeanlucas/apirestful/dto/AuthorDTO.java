package com.jeanlucas.apirestful.dto;

import java.io.Serializable;

import com.jeanlucas.apirestful.domain.User;

public class AuthorDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	
	public AuthorDTO() {}
	
	public AuthorDTO(User author) {
		id = author.getID();
		name = author.getName();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
