package com.hb.map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hb.entity.Teacher;
import com.hb.entity.TeacherDetail;

public class OneToOneDeleteTeacherDetailTest {

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
			
			// get the teacher detail object
			int theId=3;
			TeacherDetail teacherDetail = session.get(TeacherDetail.class, theId);
			
			// print the Teacher detail 
			System.out.println("teacherDetail: "+teacherDetail);
			
			//print the associated teacher
			System.out.println("the associated teacher: "+teacherDetail.getTeacher());
			
			//now let's deletes the teacher detail 
			System.out.println("Deleting TeacherDetail: "+teacherDetail);
			session.delete(teacherDetail);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		catch (Exception e) {
			
			e.printStackTrace();
		}
		finally {
			session.close();
			factory.close();
		}

	}

}
