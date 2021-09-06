package com.nagarro.output;
/*
 * @Aayush Khanna
 * Trainee Technology
 * 
 * This file is  main file to display result
 * */

//Imports
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.hibernate.Session;
import com.nagarro.input.InputAcceptor;
import com.nagarro.hibernate.*;

import com.nagarro.controller.Flight;
import com.nagarro.controller.FlightDurationComparator;
import com.nagarro.controller.FlightPriceComparator;
import com.nagarro.helperlogic.ReadData;
import com.nagarro.input.UserInput;


public class Result {
	
	//Main function
	public static void main(String[] args) throws IOException {

		//Initialization of variables and objects
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Flight> result = new ArrayList<Flight>();
		String choice = null  ;
		UserInput  userInput ;
		
		//Working of thread 
		ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
		service.scheduleAtFixedRate(new ReadData(), 0, 3, TimeUnit.SECONDS);

		do {
			userInput= InputAcceptor.enterInput();

			result.clear();
			Session session =  HibernateSF.sessionFactory.openSession();
			session.beginTransaction();
			@SuppressWarnings("unchecked")
		
			List<Flight> flightSet = session.createQuery("from Flight").getResultList();
			//System.out.println(flightSet);

		
			session.getTransaction().commit();
			session.close();
			
			//For each loop to access the data 
			for (Flight flight : flightSet) {
				if (flight.getDepartureLocation().equalsIgnoreCase(userInput.getDepartureLocation())
						&& flight.getArrivalLocation().equalsIgnoreCase(userInput.getArrivalLocation())
						&& flight.getFlightClass().equalsIgnoreCase(userInput.getFlightClass())
						&& (userInput.getFlightDate().compareTo(flight.getValidTill()) <= 0)
						&& flight.isSeatAvailability())
					result.add(flight);
			}
				
			//Sorting the result according to output preferences
			if (userInput.getOutputPreference()==1)
				Collections.sort(result, new FlightPriceComparator());
			else
				Collections.sort(result, new FlightDurationComparator());
			
			
			System.out.println("\nResult:");
			
			//for each loop to display result
			for (Flight flight : result) {
				System.out.println(flight);
			}
			
			//Asking user whether to exit or not
			System.out.print("\nWant to Exit (Enter Y/N)");
			while(!((choice = br.readLine()).equalsIgnoreCase("y")||choice.equalsIgnoreCase("n")))
				System.out.print("I could not Understand Enter Again:");
		} while (choice.equalsIgnoreCase("n"));
		
		//Shuting down the service
		service.shutdown();
	}
}
