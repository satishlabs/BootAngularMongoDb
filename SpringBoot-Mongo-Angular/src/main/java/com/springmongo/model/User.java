package com.springmongo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Document(collection = "users")
public class User {
	@Id
    private long id;
    private  String name;
    private  String email;
    
    public User() {
    	super();
    }

	public User(long id,String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}
    
    
}
