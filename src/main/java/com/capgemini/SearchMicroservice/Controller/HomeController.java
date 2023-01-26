package com.capgemini.SearchMicroservice.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/flight")
@CrossOrigin
public class HomeController {
	
	@GetMapping("/welcome")
	public String welcome() {
		String text = "this is private page"  ;
		text+= "this is not allowed to unauthenticated users";
		return text;
	}
	
	@GetMapping("/getuser")
	public String getuser() {
		
		return "{\"name\":\"admin\"}";
	}
	
	
}
