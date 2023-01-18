package com.capgemini.SearchMicroservice.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.capgemini.SearchMicroservice.Controller.SearchQuery;
import com.capgemini.SearchMicroservice.Entity.Flight;
import com.capgemini.SearchMicroservice.Entity.Inventory;
import com.capgemini.SearchMicroservice.Repository.FlightRepository;

@Service
public class FlightServiceImpl implements IFlightService{
	
	@Autowired
	private FlightRepository flightRepository;
	
	private final Logger logger=LoggerFactory.getLogger(this.getClass());

	@Override
	public List<Flight> getFlightlist() {
		
		return flightRepository.findAll();
	}

	@Override
	public List<Flight> getFlightByOriginAndDestination(String Origin, String Destination, String flightdate) {
		
		return flightRepository.findByOriginAndDestinationAndFlightdate(Origin,Destination,flightdate);
	}

	
	@Override
	public Flight getByDate(long flightNumber, String flightdate) {
		// TODO Auto-generated method stub
		return flightRepository.findByFlightNumberAndFlightdate(flightNumber,flightdate);
	}

	@Override
	public List<Flight> search(SearchQuery query) {
		// TODO Auto-generated method stub
		List<Flight> flights = flightRepository.findByOriginAndDestinationAndFlightdate(query.getOrigin(), query.getDestination(),query.getFlightdate());
		List<Flight> searchResult = new ArrayList<Flight>();
		searchResult.addAll(flights);
		flights.forEach(flight->{
			flight.getFares();
			int inv =flight.getInventory().getCount();
			if(inv==0)
			{
				searchResult.remove(flight);
			}
		});
		return searchResult;
	}

	@Override
	public void updateInventory(long flightNmber, String flightDate, int inventory) {
		Flight flight = flightRepository.findByFlightNumberAndFlightdate(flightNmber,flightDate);
		Inventory inv = flight.getInventory();
		inv.setCount(inventory);
		flightRepository.save(flight); 	 	
	}

	@Override
	public ResponseEntity<?> addFlight(Flight flight)  {
		boolean findFlightNumber= flightRepository.existsByFlightNumber(flight.getFlightNumber());
		if(findFlightNumber==true)
		{
			return new ResponseEntity<>("FlightNumber Already exists:" +flight.getFlightNumber() ,HttpStatus.FOUND);
		}
		else
			return new ResponseEntity<>(flightRepository.save(flight),HttpStatus.OK);		
	
	}

	@Override
	public Flight findByFlightNumber(Long id) {
		
		return flightRepository.findByFlightNumber(id);
	}

	@Override
	public List<Flight> FlightByOriginAndDestination(String origin, String Destination) {
		return flightRepository.findByOriginAndDestination(origin, Destination);
	}

	@Override
	public ResponseEntity<?> findbyFlightNumber(Long flightNumber) {
         boolean exists=flightRepository.existsByFlightNumber(flightNumber);
         if(exists==true)
         {
        	 Flight flight =flightRepository.findByFlightNumber(flightNumber);
        	 return new ResponseEntity<>(flight,HttpStatus.ALREADY_REPORTED);
         }
         else
         {
 
         return new ResponseEntity<>("No flight found",HttpStatus.NOT_FOUND);
         }
	}

	@Override
	public String DeleteFlight(long flightNumber) {
		boolean exists = flightRepository.existsByFlightNumber(flightNumber);
		if(exists==true)
		{
		Flight flight=  flightRepository.findByFlightNumber(flightNumber);
		long id=flight.getId();
		flightRepository.deleteById(id);
		return "Deleted : "+flightNumber;
		}
		else
			return  "FlightNumber not found";
	}

	@Override
	public List<Flight> findBydate(String flightDate) {
		// TODO Auto-generated method stub
		return flightRepository.findByFlightdate(flightDate);
	}
}
