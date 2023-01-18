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

	String fare;
	String Currency;
	
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFare() {
		return fare;
	}
	public void setFare(String fare) {
		this.fare = fare;
	}
	public String getCurrency() {
		return Currency;
	}
	public void setCurrency(String currency) {
		Currency = currency;
	}
	public Fares( String fare, String currency) {
		super();
		
		this.fare = fare;
		this.Currency = currency;
	}
	public Fares() {
		super();
	}
	
	
	
}
