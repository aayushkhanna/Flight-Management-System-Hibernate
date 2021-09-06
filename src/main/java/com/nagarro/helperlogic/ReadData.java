package com.nagarro.helperlogic;
/*
 * @Aayush Khanna
 * Trainee Technology
 * 
 * This file contains information to read the backend data and accessing the data using querries 
 * */
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.nagarro.hibernate.*;
import com.nagarro.model.Airline;
import com.nagarro.constants.ConstantValues;

public class ReadData extends ConstantValues implements Runnable   {

	//Initialization of HashMap
	static HashMap<String,Long> lastModifiedAt = new HashMap<String,Long>();
	
	
	//Run Method
    public void run()
	{
    	//Initialization 
		File files[] = FILE.listFiles();
		Session session ;
		ArrayList<String> l = new ArrayList<String>();
		
		//Foreach loop to access all files
		for (File file : files) {
			if((!(lastModifiedAt.containsKey(file.getName())))||(file.lastModified()>lastModifiedAt.get(file.getName())))
			{
				
				//Reading files in backend
				Airline airline = DirectoryReader.readFile(file) ;
				session = HibernateSF.sessionFactory.openSession();
				session.beginTransaction();
				if (!(lastModifiedAt.containsKey(file.getName()))) {
					session.persist(airline);
				}
				else {
					@SuppressWarnings("rawtypes")
					
					//creating a query
					Query query = session.createQuery(QUERY);
					
					query.setParameter("string", file.getName());
				
					Airline airlineTwo= (Airline)query.uniqueResult();
					airlineTwo = (Airline) session.load(Airline.class, airlineTwo.getId());
					session.delete(airlineTwo);
					session.persist(airlineTwo);
				}
				session.getTransaction().commit();
				session.close();
				lastModifiedAt.put(file.getName(), file.lastModified());

			}
			l.add(file.getName());
		}

		
		Set <String> fc = lastModifiedAt.keySet();
		Set <String> fileName = new HashSet<String>() ;
		fileName.addAll(fc);
		
		if(fc.size()==l.size())
			return ;
		for (String string : fileName) {
			if (!(l.contains(string)))
			{
				//Using session factory for executing query
				session = HibernateSF.sessionFactory.openSession();
				session.beginTransaction() ;
				@SuppressWarnings("rawtypes")
				Query query = session.createQuery(QUERY);
				query.setParameter("string", string);
				Airline a= (Airline)query.uniqueResult();
				a = (Airline) session.load(Airline.class, a.getId());
				session.delete(a);
				session.getTransaction().commit();
				lastModifiedAt.remove(string);
				session.close();
			}
		}
	}
}
