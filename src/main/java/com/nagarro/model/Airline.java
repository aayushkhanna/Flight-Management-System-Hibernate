package com.nagarro.model;
/*
 * @Aayush Khanna
 * Trainee Technology
 * 
 * This file contains information about flights
 * */

//import packages
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.nagarro.controller.Flight;

//Entity specifies table of sql database
@Entity
public class Airline {
	//Id specifies primary key of sql table
	@Id @GeneratedValue
	
	//Initializing variables
	int fileId ;
	String fileName ;
	
	//One to many relationships
	@OneToMany(mappedBy = "airline" , cascade =  CascadeType.ALL )
	Set<Flight> flights ;
	
	//get method for file id
	public int getId() {
		return fileId;
	}
	
	//set method for file id
	public void setFileId(int fileId) {
		this.fileId = fileId;
	}
	
	//get method for file name
	public String getFileName() {
		return fileName;
	}
	
	//set method for file name
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	//get flights information
	public Set<Flight> getFlights() {
		return flights;
	}
	
	//set flights information
	public void setFlights(Set<Flight> flights) {
		this.flights = flights;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Airline other = (Airline) obj;
		if (fileId != other.fileId)
			return false;
		if (fileName == null) {
			if (other.fileName != null)
				return false;
		} else if (!fileName.equals(other.fileName))
			return false;
		return true;
	} 
}
