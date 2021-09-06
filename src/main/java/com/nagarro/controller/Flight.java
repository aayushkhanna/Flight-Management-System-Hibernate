package com.nagarro.controller;
/*
 * @Aayush Khanna
 * Trainee Technology
 * 
 * This file contains information about flights
 * */
//Import various packages
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.nagarro.constants.ConstantValues;
import com.nagarro.model.Airline;



@Entity   //Describes the table
public class Flight extends ConstantValues {
	@Id @GeneratedValue  // specifies primary key
	
	//Initializing variables 
	int id ;
	String flightNumber ;
	String departureLocation ;
	String arrivalLocation;
	Date validTill ;
	String flightTime ;
	Double flightDuration ;
	int flightFare ;
	boolean seatAvailability;
	String flightClass ;
	
	@ManyToOne //Many to one relationships
	Airline airline ;
	
	public Flight(){
		
	}
	
	//Initialization of Flight constructor
	public Flight(String flightNumber, String departureLocation, String arrivalLocation, int flightFare,
			Date validTill, String flightTime, Double flightDuration,
			boolean seatAvailability, String flightClass,Airline airline) {
		super();
		this.flightNumber = flightNumber;
		this.departureLocation = departureLocation;
		this.arrivalLocation = arrivalLocation;
		this.validTill = validTill;
		this.flightTime = flightTime;
		this.flightDuration = flightDuration;
		this.seatAvailability = seatAvailability;
		this.flightClass = flightClass;
		if (flightClass.equalsIgnoreCase("EB"))
			flightFare = 140 * flightFare / 100;
		this.flightFare = flightFare;
		this.airline =airline;
	}
	
	//get method for flight id
	public int getId() {
		return id;
	}

	//get method details of airline
	public Airline getAirline() {
		return airline;
	}

	//get method for flight number
	public String getFlightNumber() {
		return flightNumber;
	}
	
	//get method for departure location
	public String getDepartureLocation() {
		return departureLocation;
	}
	
	//get method for arrival location
	public String getArrivalLocation() {
		return arrivalLocation;
	}
	
	//get method for flight fare
	public int getFlightFare() {
		return flightFare;
	}
	
	//get method for date of travel
	public Date getValidTill() {
		return validTill;
	}
	
	//get method for flight time
	public String getFlightTime() {
		return flightTime;
	}
	
	//get method for flight duration
	public Double getFlightDuration() {
		return flightDuration;
	}
	
	//seat availability
	public boolean isSeatAvailability() {
		return seatAvailability;
	}
	
	//get method for flight class
	public String getFlightClass() {
		return flightClass;
	}

	@Override
	//return the details according to user input
	public String toString() {
		return "FLIGHT NUMBER=" + flightNumber + ", DEPARTURE LOCATION=" + departureLocation
				+ ", ARRIVAL LOCATION=" + arrivalLocation + ", VALID TILL=" + DATE_FORMAT.format(validTill)
				+ ", FLIGHT TIME=" + flightTime + ", FLIGHT DURATION="
				+ String.format("%.2f", flightDuration) + ", FLIGHT FARE=" + flightFare + ", SEAT AVAILABILITY="
				+ seatAvailability + ", FLIGHT CLASS=" + flightClass ;
	}

	// fetching flight_number using ternary operator
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((flightNumber == null) ? 0 : flightNumber.hashCode());

		return result;
	}


	// Checking the values assigned to variables
	public boolean equals(Object obj) {
		Flight other = (Flight) obj;
		if (arrivalLocation == null) {
			if (other.arrivalLocation != null)
				return false;
		} else if (!arrivalLocation.equals(other.arrivalLocation))
			return false;
		if (departureLocation == null) {
			if (other.departureLocation != null)
				return false;
		} else if (!departureLocation.equals(other.departureLocation))
			return false;
		if (flightNumber == null) {
			if (other.flightNumber != null)
				return false;
		} else if (!flightNumber.equals(other.flightNumber))
			return false;
		if (flightTime == null) {
			if (other.flightTime != null)
				return false;
		} else if (!flightTime.equals(other.flightTime))
			return false;
		if (seatAvailability != other.seatAvailability)
			return false;
		if (validTill == null) {
			if (other.validTill != null)
				return false;
		} else if (!validTill.equals(other.validTill))
			return false;
		return true;
	}	
}