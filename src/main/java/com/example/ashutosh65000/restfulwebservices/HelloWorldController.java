package com.example.ashutosh65000.restfulwebservices;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//need to tell this is a Controller 
@RestController
public class HelloWorldController {
	
	/*
	 * Step 1. Telling this is a GET method
	 * 			a) using the annotation @RequestMapping(method=RequestMethod.GET, path="/hello-world")
	 * 			b) using the shorthand annotation @GetMapping(path="/hello-world")
	 * Step 2. The URI is /hello-world
	 * Step 3. What it should return back as the response?
	
	 */
	
	@GetMapping(path="/hello-world")
	public String helloWorld() {
		return "Hey Ashutosh! Hello";
	}
	
	@GetMapping(path="/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hey Ashutosh! Hello");
	}
	
	@GetMapping(path="/hello-world/path-variable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
		return new HelloWorldBean("Hey " + name + "!");
	}
}
