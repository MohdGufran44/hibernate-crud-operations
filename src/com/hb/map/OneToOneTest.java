package com.hb.map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hb.entity.Teacher;
import com.hb.entity.TeacherDetail;

public class OneToOneTest {

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
			
			// create the objects
			
//			Teacher tempTeacher = 
//					new Teacher("Anas", "Raza", "raza@gmail.com");
//			
//			TeacherDetail tempTeacherDetail =
//					new TeacherDetail(
//							"http://www.raza.com/youtube",
//							"Poetry!!!");		
			
			
			Teacher tempTeacher = 
					new Teacher("Noori", "Naaz", "naaz@gmail.com");
			
			TeacherDetail tempTeacherDetail =
					new TeacherDetail(
							"http://www.youtube.com",
						"stiching");		
			
			// associate the objects
			tempTeacher.setTeacherDetail(tempTeacherDetail);
			
			// start a transaction
			session.beginTransaction();
			
			// save the Teacher
			//
			// Note: this will ALSO save the details object
			// because of CascadeType.ALL
			//
			System.out.println("Saving Teacher: " + tempTeacher);
			session.save(tempTeacher);					
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}

	}

}
