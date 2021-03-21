package com.training.boot.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.boot.model.GreetingResponse;
@RestController
public class GreetingController {
	private static final String template = "Hello,%s!";
	private final AtomicLong count =new AtomicLong();
	
	@GetMapping("/greeting")
	public GreetingResponse greeting(@RequestParam(value="name",defaultValue = "World") String name) {
		return new GreetingResponse(count.incrementAndGet(),String.format(template, name));
	}
	@PostMapping("/home")
	public GreetingResponse greet(@RequestParam(value="language",defaultValue = "English")String language,@RequestParam(value="name",defaultValue = "World") String name)
	{
	 if(language.equalsIgnoreCase("French")) {
		 return new GreetingResponse(count.incrementAndGet(),"Bonjour,"+name+"!");
	 }else {
		 
		 return new GreetingResponse(count.incrementAndGet(),"Hello,"+name+"!");
	 }
	 
	}
}
