package com.nagarro.controller;

/*
 * @Aayush Khanna
 * Trainee Technology
 * 
 * This file contains flight price comparison
 * */

//Imports 
import java.util.Comparator;


public class FlightPriceComparator implements Comparator<Flight>
{
	//Comparing two prices of flights for sorting them
	public int compare(Flight flightPriceOne, Flight flightPriceTwo) {
		return flightPriceOne.getFlightFare()-flightPriceTwo.getFlightFare();
	}
}

