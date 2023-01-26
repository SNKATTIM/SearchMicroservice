package com.capgemini.SearchMicroservice.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Fares {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "fare_id")
	long id;

	long fare;
	String Currency;
	
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getFare() {
		return fare;
	}
	public void setFare(long fare) {
		this.fare = fare;
	}
	public String getCurrency() {
		return Currency;
	}
	public void setCurrency(String currency) {
		Currency = currency;
	}
	public Fares( long fare, String currency) {
		super();
		
		this.fare = fare;
		this.Currency = currency;
	}
	public Fares() {
		super();
	}
	
	
	
}
