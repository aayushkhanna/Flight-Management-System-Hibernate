package com.nagarro.helperlogic;
/*
 * @Aayush Khanna
 * Trainee Technology
 * 
 * This file used to read the data from files.
 * */

//Imports
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.ParseException;
import java.util.Date;
import java.util.HashSet;
import java.util.StringTokenizer;

import com.nagarro.constants.ConstantValues;
import com.nagarro.controller.Flight;
import com.nagarro.model.Airline;



public class DirectoryReader extends ConstantValues {

	//Read file function
	public static Airline readFile(File file) {
		//Initialisation 
		BufferedReader bufferedReader = null;
		Airline airline = new Airline();
		airline.setFileName(file.getName());
		
		//Inititialization of HashSet
		HashSet<Flight> flightSet = new HashSet<Flight>();
		
		//Reading File
		try {
			bufferedReader = new BufferedReader(new FileReader(file));
			String string = bufferedReader.readLine();
			string = bufferedReader.readLine();
			
			while (string!= null) {
		    	Flight f = readLine(string,airline);
				string = bufferedReader.readLine();
				flightSet.add(f);
			}
		} catch (Exception e) {
			System.err.println(FILE_NOT_LOADED);
		} finally {
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (Exception exception) {
					System.err.println(FILE_CANNOT_CLOSE);
				}
			}
		}
		airline.setFlights(flightSet); 
	
		return airline;
	}

	//Read Line method
	private static Flight readLine(String string, Airline airline) {

		StringTokenizer stringTokenizer = new StringTokenizer(string, "|");

		String flightNumber = stringTokenizer.nextToken();
		String departureLocation = stringTokenizer.nextToken();
		String arrivalLocation = stringTokenizer.nextToken();

		String validTillDate = stringTokenizer.nextToken();
		Date validTill = new Date();
		try {
			validTill = DATE_FORMAT.parse(validTillDate);
		} catch (ParseException exception) {
			System.err.print(DATE_FORMAT_ERROR);
		}

		String flightTime = stringTokenizer.nextToken();
		Double flightDuration = Double.parseDouble(stringTokenizer.nextToken());
		int flightFare = Integer.parseInt(stringTokenizer.nextToken());

		String seatAvailable = stringTokenizer.nextToken();
		Boolean seatAvailability;
		if (seatAvailable.charAt(0) == 'Y')
			seatAvailability = true;
		else
			seatAvailability = false;

		String flightClass = stringTokenizer.nextToken();

		//Return flight data
		return new Flight(flightNumber, departureLocation, arrivalLocation, flightFare, validTill,
				flightTime, flightDuration, seatAvailability, flightClass,airline);
		}
}
