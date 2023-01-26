package com.capgemini.SearchMicroservice.Config;

import org.aspectj.apache.bcel.classfile.Module.Provide;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.capgemini.SearchMicroservice.Service.CustomUserDetailsService;


@Configuration
@EnableWebSecurity

public class MySecurityConfig  {
	
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	
	@Autowired
	private JwtAuthenticationFilter jwtAuthenticationFilter;
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception
	{
		
		http
		
		    .csrf()
		    .disable()
		    .cors()
		    .disable()
		    .authorizeRequests()
		    //.requestMatchers("/token").permitAll()
		    .anyRequest()
		    .permitAll()
		    //.authenticated()
		    .and()
		    .headers().frameOptions().sameOrigin()
		    .and()
		    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		http.addFilterBefore(this.jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
		http.authenticationProvider(daoAuthenticationProvider());
		
		
		DefaultSecurityFilterChain defaultSecurityFilterChain = http.build();
		
		return defaultSecurityFilterChain;
		
		
    }
			
	
//	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
//		auth.userDetailsService(customUserDetailsService);
//	}
	
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return NoOpPasswordEncoder.getInstance();
	}
	

	
	@Bean
	public DaoAuthenticationProvider daoAuthenticationProvider() {
		
		DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
		provider.setUserDetailsService(this.customUserDetailsService);
		provider.setPasswordEncoder(passwordEncoder());
 
		return provider;
		
		
	}
	
	
	
//	@Bean
//	@Override
//	public AuthenticationManager authenticationManagerBean() throws Exception
//	{
//		return super.authenticationManagerBean();
//	}
	
	@Bean
	
	public AuthenticationManager authenticationManagerBean(AuthenticationConfiguration configuration) throws Exception
	{
		return configuration.getAuthenticationManager() ;
	}

}
