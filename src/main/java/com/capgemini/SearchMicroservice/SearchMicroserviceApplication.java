package com.capgemini.SearchMicroservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.client.RestTemplate;

import com.capgemini.SearchMicroservice.Entity.Fares;
import com.capgemini.SearchMicroservice.Entity.Flight;
import com.capgemini.SearchMicroservice.Entity.Inventory;
import com.capgemini.SearchMicroservice.Repository.FlightRepository;

@SpringBootApplication
public class SearchMicroserviceApplication implements CommandLineRunner{

	@Autowired
	private FlightRepository repo;
	
	public static void main(String[] args) {
		SpringApplication.run(SearchMicroserviceApplication.class, args);
	}
	
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate()
	{
		return new RestTemplate();
	}
	

	@Override
	public void run(String... args) throws Exception {
		List<Flight> flights = new ArrayList<Flight>();
		flights.add(new Flight(26333, "AirIndia","BANG-Banglore","CHN-Chennai","16-01-2023","12:05",new Fares(2530, "INR"),new Inventory(2)));
		flights.add(new Flight(90001, "AirIndia","BANG-Banglore","MYS-Mysore","16-01-2023","12:00",new Fares(2999, "INR"),new Inventory(200)));
		flights.add(new Flight(92331, "AirIndia","BANG-Banglore","CHN-Chennai","16-01-2023","12:30",new Fares(2000, "INR"),new Inventory(200)));
		flights.add(new Flight(1001, "KingFisher","CHN-Chennai","BANG-Banglore","17-01-2023","08:00",new Fares(1590, "INR"),new Inventory(200)));
		flights.add(new Flight(10031, "KingFisher","MUM-Mumbai","BANG-Banglore","16-01-2023","09:00",new Fares(1999, "INR"),new Inventory(200)));
		flights.add(new Flight(30009, "Indigo","MUM-Mumbai","CHN-Chennai","16-01-2023","19:00",new Fares(1000, "INR"),new Inventory(200)));
		flights.add(new Flight(30044, "Indigo","MYS-Mysore","BANG-Banglore","18-01-2023","19:08",new Fares(2690, "INR"),new Inventory(200)));
		flights.add(new Flight(3002, "Indigo","CHN-Chennai","BANG-Banglore","16-01-2023","15:15",new Fares(2000, "INR"),new Inventory(200)));
		flights.add(new Flight(78891, "AirAsia","DLH-Delhi","MUM-Mumbai","20-01-2023","06:25",new Fares(2100, "INR"),new Inventory(200)));
		repo.saveAll(flights);
		
	}

	


	
	
	
	

	
	
}
