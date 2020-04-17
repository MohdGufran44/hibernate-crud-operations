package com.hb.oneToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hb.entity.Teacher;
import com.hb.entity.TeacherDetail;

public class DeleteTest {

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

			// get ieacher by primary key / id
			int theId = 1;
			Teacher tempTeacher = 
					session.get(Teacher.class, theId);
			
			System.out.println("Found teacher: " + tempTeacher);
			
			// delete the instructors
			if (tempTeacher != null) {
			
				System.out.println("Deleting: " + tempTeacher);
				
				// Note: will ALSO delete associated "details" object
				// because of CascadeType.ALL
				//
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
