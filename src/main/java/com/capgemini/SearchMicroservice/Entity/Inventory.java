package com.capgemini.SearchMicroservice.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Inventory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "inv_id")
	private long id;
	
	int count;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Inventory( int count) {
		super();
		
		this.count = count;
	}

	public Inventory() {
		super();
	}
	
	
	
	
	
	
	

}
