package com.hb.eagervslazy;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hb.entity.Course;
import com.hb.entity.Teacher;
import com.hb.entity.TeacherDetail;

public class EagerLazyTest {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Teacher.class)
								.addAnnotatedClass(TeacherDetail.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
try {			
			
			// start a transaction
			session.beginTransaction();
			
			// get the teacher from db
			int theId = 1;
			Teacher tempTeacher = session.get(Teacher.class, theId);		
			
			System.out.println(": Teacher: " + tempTeacher);
		
			System.out.println(": Courses: " + tempTeacher.getCourses());
			
			// commit transaction
			session.getTransaction().commit();
			
			// close the session
			session.close();
			
			System.out.println("\nluv2code: The session is now closed!\n");

			// option 1: call getter method while session is open
			
			// get courses for the instructor
			System.out.println("luv2code: Courses: " + tempTeacher.getCourses());
			
			System.out.println("luv2code: Done!");
		}
		finally {
			
			// add clean up code
			session.close();
			
			factory.close();
		}
	}

}
