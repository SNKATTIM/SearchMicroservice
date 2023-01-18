package com.capgemini.SearchMicroservice.Controller;

import org.springframework.format.annotation.DateTimeFormat;

public class SearchQuery {
	
	private String origin;
	private String destination;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private String flightdate;

	public String getOrigin() {
		return origin;
	}

	public String getDestination() {
		return destination;
	}

	public String getFlightdate() {
		return flightdate;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public void setFlightdate(String flightdate) {
		this.flightdate = flightdate;
	}

	@Override
	public String toString() {
		return "SearchQuery [origin=" + origin + ", destination=" + destination + ", flightdate=" + flightdate + "]";
	}

	public SearchQuery(String origin, String destination, String flightdate) {
		super();
		this.origin = origin;
		this.destination = destination;
		this.flightdate = flightdate;
	}

	public SearchQuery() {
		super();
	}
	
	
	
	

}
