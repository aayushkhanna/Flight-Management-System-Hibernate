package com.nagarro.controller;
/*
 * @Aayush Khanna
 * Trainee Technology
 * 
 * This class is used to compare and sort according to duration
 * */
import java.util.Comparator;

public class FlightDurationComparator implements Comparator<Flight> {

	//Comparison method
	public int compare(Flight flightOne, Flight flightTwo) {
		//Comparing duration of two files
		Double durationComparison  = flightOne.getFlightDuration()-flightTwo.getFlightDuration() ;
		if (durationComparison<0)
		return -1;
		else if (durationComparison>0)
			return 1 ;
		else
			return 0;
			
	}

}


