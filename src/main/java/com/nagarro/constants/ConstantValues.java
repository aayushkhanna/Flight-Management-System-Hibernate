package com.nagarro.constants;
/*
 * @Aayush Khanna
 * Trainee Technology
 * Constant values
 * 
 * 
 * This class contains all the constant values of strings and formats which have been used in  the project
 *  
 * */
import java.io.File;
import java.text.SimpleDateFormat;

public class ConstantValues {
	public static final File FILE = new File("CSV/");
	public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");
	public static final String DATE_FORMAT_ERROR = "Date not in appropriate(dd-MM-yyyy) format, Enter Again: ";
	public static final String DEPARTURE_LOCATION_QUERY = "select distinct departureLocation from Flight";
	public static final String DEPARTURE_LOCATION_ERROR = "Flights from no such stations found, Kindly Enter Again: ";
	public static final String ARRIVAL_LOCATION_QUERY ="select distinct arrivalLocation from Flight";
	public static final String ARRIVAL_LOCATION_ERROR = "Flights to no such stations found, Kindly Enter Again: ";
	public static final String FLIGHT_CLASS_ERROR = "Flight Class entered Inappropriately, Enter Again :";
	public static final String OUTPUT_PREFERENCE_ERROR = "Output preference entered Inappropriately, Enter Again : ";
	public static final String FILE_NOT_LOADED = "Could Not Read the File";
	public static final String FILE_CANNOT_CLOSE = "Could Not Close the File";
	public static final String QUERY = "from Airline where name = :string";
}
