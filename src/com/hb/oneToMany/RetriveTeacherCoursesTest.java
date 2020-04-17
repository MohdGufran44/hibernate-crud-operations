package com.hb.oneToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hb.entity.Course;
import com.hb.entity.Teacher;
import com.hb.entity.TeacherDetail;

public class RetriveTeacherCoursesTest {

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
					
					// get the Teacher from db
					int theId = 1;
					Teacher tempTeacher = session.get(Teacher.class, theId);		
					
					System.out.println("Instructor: " + tempTeacher);
					
					// get courses for the Teacher
					System.out.println("Courses: " + tempTeacher.getCourses());
					
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
