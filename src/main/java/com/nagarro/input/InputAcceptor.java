package com.nagarro.input;
/*
 * @Aayush Khanna
 * Trainee Technology
 * 
 * Flight Management System - Hibernate
 * 
 * This file takes input from the user and search accordingly and display results. 
 * */

//import packages
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

//import other java classes
import com.nagarro.constants.ConstantValues;
import com.nagarro.validations.UserInputValidator;

public class InputAcceptor extends ConstantValues {

	public static UserInput enterInput() throws IOException {
		
		//Buffere Reader object 
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		
		//Initializing variables
		String departureLocation, arrivalLocation, flightClass;
		int outputPreference;
		Date flightDate = null;

		//Taking departure location as user input
		System.out.print("Enter departure location :  ");
       // checking departure location validity
		while ((departureLocation = UserInputValidator.validateDepartureLocation(bufferedReader.readLine())) == null) {
			continue;
		}

		//Taking arrival location as user input
		System.out.print("Enter arrival location:  ");
		//checking arrival  location validity
		while ((arrivalLocation = UserInputValidator.validateArrivalLocation(bufferedReader.readLine())) == null) {
			continue;
		}

		//Taking flight class as user input
		System.out.print("Enter flight class: ");
		//checking flight class validity
		while ((flightClass = UserInputValidator.validateFlightClass(bufferedReader.readLine())) == null) {
			continue;
		}

		//Taking date of travel as user input
		System.out.print("Enter Date Of Travel(DD-MM-YYYY): ");
		//checking date of travel on which the customer wants to travel validity
		while ((flightDate = UserInputValidator.validateDate(bufferedReader.readLine())) == null) {
			continue;
		}

		//Taking output preference as user input
		System.out.print("Enter your Output preference(Sort by Fare/Duration)):\n(Enter 1/2): ");
		//Checking validity of output preference 
		while ((outputPreference = UserInputValidator.validateOutputPreference(Integer.parseInt(bufferedReader.readLine()))) == 0) {
			continue;
		}

		//return the user input 
		return new UserInput(departureLocation, arrivalLocation, flightDate,
				flightClass, outputPreference);
	}
}
