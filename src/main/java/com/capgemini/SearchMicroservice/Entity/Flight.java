package com.capgemini.SearchMicroservice.Entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Table(name = "flight")

public class Flight {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private long flightNumber;
	private String flight_Name;
	private String origin;
	private String destination;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private String flightdate;
	
	@DateTimeFormat(pattern = "'T'HH:mm") 
	private	String Flight_time;
	 	
	
	@OneToOne(cascade = CascadeType.ALL)
	  @JoinColumn(name="fare_Id") 
	  Fares fares;
	  
	  @OneToOne(cascade = CascadeType.ALL)
	  @JoinColumn(name="inv_Id") 
	  Inventory inventory;

	public long getId() {
		return id;
	}

	public long getFlightNumber() {
		return flightNumber;
	}

	public String getFlight_Name() {
		return flight_Name;
	}

	public String getOrigin() {
		return origin;
	}

	public String getDestination() {
		return destination;
	}

	public String getFlightdate() {
		return flightdate;
	}

	public Fares getFares() {
		return fares;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setFlightNumber(long flightNumber) {
		this.flightNumber = flightNumber;
	}

	public void setFlight_Name(String flight_Name) {
		this.flight_Name = flight_Name;
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

	public void setFares(Fares fares) {
		this.fares = fares;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}	
	
	public String getFlight_time() {
		return Flight_time;
	}

	public void setFlight_time(String flight_time) {
		Flight_time = flight_time;
	}

	public Flight() {
		super();
	}

	public Flight(long flightNumber, String flight_Name, String origin, String destination, String flightdate,
			String flight_time, Fares fares, Inventory inventory) {
		super();
		this.flightNumber = flightNumber;
		this.flight_Name = flight_Name;
		this.origin = origin;
		this.destination = destination;
		this.flightdate = flightdate;
		Flight_time = flight_time;
		this.fares = fares;
		this.inventory = inventory;
	}

	@Override
	public String toString() {
		return "Flight [id=" + id + ", flightNumber=" + flightNumber + ", flight_Name=" + flight_Name + ", origin="
				+ origin + ", destination=" + destination + ", flightdate=" + flightdate + ", Flight_time="
				+ Flight_time + ", fares=" + fares + ", inventory=" + inventory + "]";
	}
	
	

	

	  	  
}
