package com.capgemini.SearchMicroservice.Repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capgemini.SearchMicroservice.Entity.Flight;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> 
{
	/*
	 * @Query(value=
	 * "select * from flight where origin=?1 and destination=?2",nativeQuery = true)
	 * public List<Flight> getFlightByOriginAndDestination(String Origin,String
	 * Destination);
	 */
	
	List<Flight> findByOriginAndDestinationAndFlightdate(String origin,String destination, String flightdate);

	Flight findByFlightNumber(Long flightNumber);
	
	Flight findByFlightNumberAndFlightdate(long flightNumber, String flightdate);
	
	boolean existsByFlightNumber(long flightNumber);
	
	List<Flight> findByOriginAndDestination(String origin, String destination);
	
	List<Flight> findByFlightdate(String flightdate);
	
	
	
	

}
