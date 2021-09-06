package com.nagarro.hibernate;
/*
 * @Aayush Khanna
 * Trainee Technology
 * 
 * This file contains hibernate session 
 * */
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSF {
	//configuring hibernate files
	public static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
}
