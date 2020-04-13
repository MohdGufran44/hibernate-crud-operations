package com.hb.dcon;

import java.sql.Connection;
import java.sql.DriverManager;

public class HibernateConTest {

	public static void main(String[] args) {
		
		String jdbcUrl="jdbc:mysql://localhost:3306/hibernate_student_tracker?useSSL=false";
		String user="root";
		String pass="Raza@786";
		try {
			System.out.println("Connecting to Database: "+jdbcUrl);	
			Connection con=DriverManager.getConnection(jdbcUrl, user, pass); 
			System.out.println("Connection successful!!");
		}
		catch(Exception ex){
			ex.printStackTrace();
		}

	}

}
