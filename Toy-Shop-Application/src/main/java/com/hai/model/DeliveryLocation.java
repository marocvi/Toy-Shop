package com.hai.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Delivery_Location")
public class DeliveryLocation {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Delivery_Location_ID")
	private int id;
	@Column(name="Available_Location")
	private String availableLocation;
	@Column(name="Type_Of_Transport")
	private String typeOfTransport;
	private String duration;
	
	
	
	
	//Getter and setter
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAvailableLocation() {
		return availableLocation;
	}
	public void setAvailableLocation(String availableLocation) {
		this.availableLocation = availableLocation;
	}
	public String getTypeOfTransport() {
		return typeOfTransport;
	}
	public void setTypeOfTransport(String typeOfTransport) {
		this.typeOfTransport = typeOfTransport;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	
	
	
}
