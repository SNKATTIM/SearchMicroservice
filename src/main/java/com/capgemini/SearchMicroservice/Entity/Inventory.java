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
	
	long count;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

	public Inventory( long count) {
		super();
		
		this.count = count;
	}

	public Inventory() {
		super();
	}
	
	
	
	
	
	
	

}
