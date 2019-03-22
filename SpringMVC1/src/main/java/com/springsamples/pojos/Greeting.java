package com.springsamples.pojos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


public class Greeting {
	
	private String message = "Greetings from Spring 4!";
	

	
	public Greeting(String newMessage){
		setMessage(newMessage);
	}



	public String getMessage() {
		return message;
	}



	public void setMessage(String message) {
		this.message = message;
	}

}
