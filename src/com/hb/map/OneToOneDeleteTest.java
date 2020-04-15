package com.hb.map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hb.entity.Teacher;
import com.hb.entity.TeacherDetail;

public class OneToOneDeleteTest {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Teacher.class)
								.addAnnotatedClass(TeacherDetail.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			
			
			
			// start a transaction
			session.beginTransaction();
			
			//get instructor by primary key / id
			int theId=2;
			Teacher tempTeacher = session.get(Teacher.class,theId);
			
			System.out.println("Found teacher: "+tempTeacher);
			
			//Delete the instructors
			if(tempTeacher != null) {
				System.out.println("Deleting: "+tempTeacher);
				
				session.delete(tempTeacher);
			}
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}

	}

}
