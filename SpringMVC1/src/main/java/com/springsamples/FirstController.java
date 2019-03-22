package com.springsamples;

import java.util.Locale;


import java.util.ResourceBundle;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class FirstController {
	
/*@GetMapping("/GetFirst")
public ResponseEntity firstGetCall(){
	String message = "Hi, This is First Sample";
	return new ResponseEntity(message, HttpStatus.OK);
}*/

	@GetMapping(value = "/free", produces = "application/json")
	public @ResponseBody String firstGetCall(){
		String message =null;
		try {
			message = new ObjectMapper().writeValueAsString("This is for free Sample call");
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return message;
	}	
	
/*	@GetMapping(value="/getView")								// rendering views is not recommended for restcontroller, though it can be achieved.
	public ModelAndView firstView(){
		ModelAndView mav = new ModelAndView("firstView");
		return mav;
	}*/
	
	
	@GetMapping(value = "greetings")
	public ModelAndView firstLocale(){
		ModelAndView mav = new ModelAndView("localgreet");
		Locale.setDefault(new Locale("hi","IN"));
		ResourceBundle bun = ResourceBundle.getBundle("MyLocale");
		
		String one = bun.getString("Good_morning");
		mav.addObject("morning", one);
		String two = bun.getString("Good_bye");
		mav.addObject("evening", two);
		mav.addObject("three", "no object");
		return mav;
	}
	
	@GetMapping(value = "/")
	public ModelAndView firstView(){
		ModelAndView mav = new ModelAndView("greet");
		mav.addObject("greeting", "GeeksForGeeks Welcomes you to Spring!");
		return mav;
	}
	
	
	
}
