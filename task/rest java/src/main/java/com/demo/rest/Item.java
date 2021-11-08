package com.demo.rest;

import java.io.Serializable;

public class Item implements Serializable{
	
 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long id;
	private String name;
	private double price;
	private String details;
 
public Item(long id, String name, double price) {
	this.id = id;
	this.name = name;
	this.price = price;
}

public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public double getPrice() {
	return price;
}

public void setPrice(double price) {
	this.price = price;
}

public String getDetails() {
	return details;
}

public void setDetails(String details) {
	this.details = details;
}
}