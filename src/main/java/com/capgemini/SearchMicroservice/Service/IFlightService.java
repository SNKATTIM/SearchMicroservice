package com.capgemini.SearchMicroservice.Service;

import java.util.Date;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.capgemini.SearchMicroservice.Controller.SearchQuery;
import com.capgemini.SearchMicroservice.Entity.Flight;

public interface IFlightService
{
	public List<Flight> getFlightlist();
	public List<Flight> getFlightByOriginAndDestination(String Origin, String Destination, String flightdate);
	public Flight getByDate(long flightNumber, String flightdate);
	public List<Flight> search(SearchQuery query);
	public void updateInventory(long flightNmber, String flightDate, int inventory);
	public ResponseEntity<?> addFlight(Flight flight) throws Exception;
	public Flight findByFlightNumber(Long id);
	public List<Flight> FlightByOriginAndDestination(String origin,String Destination);
	public ResponseEntity<?> findbyFlightNumber (Long flightNumber);
	public String DeleteFlight(long flightNumber);
	public List<Flight> findBydate(String flightDate);

	
	

}
