package com.capgemini.SearchMicroservice.Service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.capgemini.SearchMicroservice.Entity.CustomUserDetails;

import com.capgemini.SearchMicroservice.Repository.UserRepository;


@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userrepo;
	
	
	
	@Override
	public UserDetails loadUserByUsername(String username)throws UsernameNotFoundException{
		
		/*User user =this.userrepo.findByUsername(username);
		if(user ==null)
		{
			throw new UsernameNotFoundException("user not found");
			
		}else
		{
			return new CustomUserDetails(user);
		}*/
		
		
		
		
	
		
		
		
		if(username.equals("admin"))
		{
			return new User("admin", "password",new ArrayList<>());
		}else {
			throw new UsernameNotFoundException("not found");
		}
		
	}
	
}
