package com.capgemini.SearchMicroservice.Controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.SearchMicroservice.Entity.Fares;
import com.capgemini.SearchMicroservice.Entity.Flight;
import com.capgemini.SearchMicroservice.Entity.Inventory;
import com.capgemini.SearchMicroservice.Repository.FlightRepository;
import com.capgemini.SearchMicroservice.Service.FlightServiceImpl;

@RestController
@RequestMapping("/api/flight")
public class FlightController 
{
	@Autowired
	public FlightServiceImpl flightImpl;
	
	@Autowired
	public FlightRepository repo;
	
		
	@GetMapping("/getall")
	public List<Flight> getAll(){
		return flightImpl.getFlightlist();
		
	}
	@PostMapping("/getbyoriginAndDest/{Origin}/{Destination}/{flightdate}")
	public List<Flight> getbyoriginAndDest(@PathVariable String Origin,@PathVariable String Destination, @PathVariable String flightdate){
		return flightImpl.getFlightByOriginAndDestination(Origin, Destination,flightdate);
	}
	
	@PostMapping("/date/{flightNumber}/{flightdate}")
	public Flight getByDate(@PathVariable long flightNumber, @PathVariable String flightdate )
	{
		return flightImpl.getByDate(flightNumber,flightdate);
		
	}
	@PostMapping("/get")
	public ResponseEntity<?> search(@RequestBody SearchQuery q)
	{
		System.out.println("Input:"+q);
		 List<Flight> f =flightImpl.search(q);
		 
		 if(f.isEmpty())
		 {
			 return new ResponseEntity<>("Flight has No seats",HttpStatus.BAD_REQUEST );
		 }
		 else
			 return new ResponseEntity<>(f,HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> addFlight(@RequestBody Flight flight) {
		 
		 
	           return new ResponseEntity<>(flightImpl.addFlight(flight),HttpStatus.OK);
		 
	/*	 catch(Exception w)
		 {
			 return new ResponseEntity<>(w,HttpStatus.BAD_REQUEST);
		 }*/
	}
	
	@GetMapping("/flightNumber/{flightNumber}")
	public ResponseEntity<?> findByFlightNumber(@PathVariable Long flightNumber )
	{
		return new ResponseEntity<>(flightImpl.findByFlightNumber(flightNumber),HttpStatus.OK);
	}
	
	
	@GetMapping("/Origin/Dest/{origin}/{destination}")
	public ResponseEntity<?> findByOriginAndDestination(@PathVariable String origin, @PathVariable String destination)
	{
		List<Flight> flight=flightImpl.FlightByOriginAndDestination(origin, destination);
		if(flight.isEmpty())
		{
			return new ResponseEntity<>("No Flight found",HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<> (flightImpl.FlightByOriginAndDestination(origin, destination),HttpStatus.OK);
	}
	
	@GetMapping("/find/{flightNumber}")
	public ResponseEntity<?> findByNumber(@PathVariable Long flightNumber)
	{
		return new ResponseEntity<>(flightImpl.findbyFlightNumber(flightNumber),HttpStatus.OK);
	}
	
	
	@DeleteMapping("/delete/{flightNumber}")
	public ResponseEntity<?> DeleteByFlightNumber(@PathVariable long flightNumber)
	{
		return new ResponseEntity<>(flightImpl.DeleteFlight(flightNumber),HttpStatus.OK);
	}
	
	@GetMapping("/Date/{flightDate}")
	public ResponseEntity<?> findByDate(@PathVariable String flightDate)
	{
		return new ResponseEntity<>(flightImpl.findBydate(flightDate),HttpStatus.OK);
	}
	
	
	

	
	
	
	
	
	
	

}
