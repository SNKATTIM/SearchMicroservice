package com.capgemini.SearchMicroservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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

	@Override
	public void run(String... args) throws Exception {
		List<Flight> flights = new ArrayList<Flight>();
		flights.add(new Flight(26333, "AirIndia","BANG-Banglore","CHN-Chennai","2023-01-16","12:05",new Fares("2530", "INR"),new Inventory(100)));
		flights.add(new Flight(90001, "AirIndia","BANG-Banglore","MYS-Mysore","2023-01-16","12:00",new Fares("2999", "INR"),new Inventory(100)));
		flights.add(new Flight(92331, "AirIndia","BANG-Banglore","CHN-Chennai","2023-01-16","12:30",new Fares("2000", "INR"),new Inventory(100)));
		flights.add(new Flight(1001, "KingFisher","CHN-Chennai","BANG-Banglore","2023-01-17","08:00",new Fares("1590", "INR"),new Inventory(100)));
		flights.add(new Flight(10031, "KingFisher","MUM-Mumbai","BANG-Banglore","2023-01-16","09:00",new Fares("1999", "INR"),new Inventory(100)));
		flights.add(new Flight(30009, "Indigo","MUM-Mumbai","CHN-Chennai","2023-01-16","19:00",new Fares("1000", "INR"),new Inventory(100)));
		flights.add(new Flight(30044, "Indigo","MYS-Mysore","BANG-Banglore","2023-01-18","19:08",new Fares("2690", "INR"),new Inventory(100)));
		flights.add(new Flight(3002, "Indigo","CHN-Chennai","BANG-Banglore","2023-01-16","15:15",new Fares("2000", "INR"),new Inventory(110)));
		flights.add(new Flight(78891, "AirAsia","DLH-Delhi","MUM-Mumbai","2023-01-20","06:25",new Fares("2100", "INR"),new Inventory(100)));
		repo.saveAll(flights);
		
	}

	


	
	
	
	

	
	
}
