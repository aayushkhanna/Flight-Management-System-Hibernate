package com.nagarro.input;
/*
 * @Aayush Khanna
 * Trainee Technology
 * User Input
 * 
 * 
 * This class helps in geting the user input basically this file contains all the getters and setters.
 * 
 * */

//Import packages
import java.util.Date;

//Import classes
import com.nagarro.constants.ConstantValues;


public class UserInput extends ConstantValues {
	//Initializing variables
	String departureLocation ;
	String arrivalLocation ;
	Date flightDate ;
	String flightClass ;
	int outputPreference ;
	
	//Initializing UserInput constructor
	public UserInput(String departureLocation, String arrivalLocation, Date flightDate,
			String flightClass, int outputPreference) {
		super();
		this.departureLocation = departureLocation;
		this.arrivalLocation = arrivalLocation;
		this.flightDate = flightDate;
		this.flightClass = flightClass;
		this.outputPreference = outputPreference;
	}
	
	//Get Method for departure location
	public String getDepartureLocation() {
		return departureLocation;
	}

	//get method for arrival location
	public String getArrivalLocation() {
		return arrivalLocation;
	}

	//get method for flight date
	public Date getFlightDate() {
		return flightDate;
	}

	//get method for flight class
	public String getFlightClass() {
		return flightClass;
	}

	//get method for output preference
	public int getOutputPreference() {
		return outputPreference;
	}

	//return the following data 
	@Override
	//To string method used to return string value
	public String toString() {
		return "DEPARTURE LOCATION =" + departureLocation + ", ARRIVAL LOCATION=" + arrivalLocation
				+ ", flightDate=" + DATE_FORMAT.format(flightDate) + ", flightClass=" + flightClass
				+ ", outputPreference=" + outputPreference ;
	}	
}
