package com.hb.oneToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hb.entity.Course;
import com.hb.entity.Teacher;
import com.hb.entity.TeacherDetail;

public class CreateInstructorTest {
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
			
			// create the objects			
			Teacher tempTeacher = 
					new Teacher("Firoz", "Public", "firoz@gmail.com");
			
			TeacherDetail tempTeacherDetail =
					new TeacherDetail(
							"http://www.youtube.com",
							"Video Games");		
			
			// associate the objects
			tempTeacher.setTeacherDetail(tempTeacherDetail);
			
			// start a transaction
			session.beginTransaction();
			
			// save the instructor
			//
			// Note: this will ALSO save the details object
			// because of CascadeType.ALL
			//
			System.out.println("Saving instructor: " + tempTeacher);
			session.save(tempTeacher);					
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			
			// add clean up code
			session.close();
			
			factory.close();
		}
	}
}
