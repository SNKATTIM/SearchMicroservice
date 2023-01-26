package com.capgemini.SearchMicroservice.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.SearchMicroservice.Service.CustomUserDetailsService;
import com.capgemini.SearchMicroservice.Utility.JwtUtility;
import com.capgemini.SearchMicroservice.model.JwtRequest;
import com.capgemini.SearchMicroservice.model.JwtResponse;

@RestController
@RequestMapping("api/flight")
@CrossOrigin
public class JwtController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	@Autowired
	private JwtUtility jwtUtility;
	
	@RequestMapping(value="/token",method = RequestMethod.POST)
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest ) throws Exception
	{
		System.out.println(jwtRequest);
		
		try 
		{
			
			this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword()));
			
		}
		catch(UsernameNotFoundException e)
		{
			e.printStackTrace();
			throw new Exception("bad credentials");
		}catch (BadCredentialsException e)
		{
			e.printStackTrace();
			throw new Exception("bad credentials");
		}
		
		
		
		
		UserDetails userDetails = this.customUserDetailsService.loadUserByUsername(jwtRequest.getUsername());
		
		String token = this.jwtUtility.generateToken(userDetails);
		System.out.println("jwt"+token);
		
		//{"token":"value"}
		
		return ResponseEntity.ok(new JwtResponse(token));
	}

}
