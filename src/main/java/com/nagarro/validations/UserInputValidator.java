package com.nagarro.validations;
/*
 * @Aayush Khanna
 * Trainee Technology
 * 
 * Flight Management System - Hibernate
 * 
 * This class contains all the validations used in the code 
 * */

//Import packages
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;

//import classes
import com.nagarro.constants.ConstantValues;
import com.nagarro.hibernate.HibernateSF;

public class UserInputValidator extends ConstantValues {
	
	//Validate date 
	public static Date validateDate(String validateDateString)
	{
		DATE_FORMAT.setLenient(false);
		Date validTill = null;
		try {
			validTill =  DATE_FORMAT.parse(validateDateString);
		} catch (ParseException e) {
			System.err.print(DATE_FORMAT_ERROR);
		}
		return validTill ;
	}


	//Validate departure location 
	public static String validateDepartureLocation(String departureLocationString) {
		//Session Factory object
		Session session =  HibernateSF.sessionFactory.openSession();
		session.beginTransaction();
	
		@SuppressWarnings("unchecked")
		List<String> flightSet = session.createQuery(DEPARTURE_LOCATION_QUERY).getResultList();
			
		session.getTransaction().commit();
		session.close();
		for (String f : flightSet )
		{
			//System.out.println(f);
			if (f.equalsIgnoreCase(departureLocationString))
				return f ;
		}
		System.err.print(DEPARTURE_LOCATION_ERROR);
		return null;
	}

	//Validate Arrival location
	public static String validateArrivalLocation(String arrivalLocationString) {
		Session session =  HibernateSF.sessionFactory.openSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<String> flightSet= session.createQuery(ARRIVAL_LOCATION_QUERY).getResultList();
		
		session.getTransaction().commit();
		session.close();
		for (String f : flightSet )
		{
			System.out.println(f);
			if (f.equalsIgnoreCase(arrivalLocationString))
				return f ;
		}
		System.err.print(ARRIVAL_LOCATION_ERROR);
		return null;
	}

	//Validate flight class
	public static String validateFlightClass(String flightClassString) {
		if (flightClassString.equalsIgnoreCase("E")||flightClassString.equalsIgnoreCase("EB")||flightClassString.equalsIgnoreCase("B")) {
			if(flightClassString.equalsIgnoreCase("B")) {
				return "EB";
			}
			return flightClassString.toUpperCase() ;
			}
		else
		{
			System.err.print(FLIGHT_CLASS_ERROR);
			return null;
		}
	}

	//Validate output preference
	public static int validateOutputPreference(int i) {
		if((i==1)||(i==2))
			return i ;
		else
		{
			System.err.print(OUTPUT_PREFERENCE_ERROR);
			return 0;
		}
	}
}