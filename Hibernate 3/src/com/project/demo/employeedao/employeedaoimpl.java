package com.project.demo.employeedao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.project.demo.employee;

public class employeedaoimpl implements employeedao {

	@Override
	public void saveemployeedetails() {
		System.out.println("employeedaoimpl.saveemployeedetails()");
		SessionFactory sessionfactory=null;
		Session session=null;
		try {
			Configuration config=new Configuration();
			config.addAnnotatedClass(employee.class);
			config.configure("hibernate.cfg.xml");
			sessionfactory=config.buildSessionFactory();
			 session=sessionfactory.openSession();
			session.beginTransaction();
			employee emp=new employee(5, "srini", 35, "M", 40000);
			employee emp2=new employee(6, "karthi", 28, "M", 35000);
			session.save(emp2);
			System.out.println("data saved sucessfully");
			session.getTransaction().commit();
			
			
		}
		catch(HibernateException e) {
			System.out.println(e.getMessage());
		}
	 finally {
		 if(session!=null) {
			 System.out.println("session is closed");
			 session.close();
		 }
		 else {
			 System.out.println("session is not closed");
		 }
		 if(sessionfactory!=null) {
			 System.out.println("session factory is closed");
			 sessionfactory.close();
		 }
		 else {
			 System.out.println("session factory is not closed");
		 }
	 }
		
		
	}

	@Override
	public void getemployeedetails() {
		System.out.println("employeedaoimpl.getemployeedetails()");
		SessionFactory sessionfactory=null;
		Session session=null;
		try {
			Configuration config=new Configuration();
			config.addAnnotatedClass(employee.class);
			config.configure("hibernate.cfg.xml");
			sessionfactory=config.buildSessionFactory();
			 session=sessionfactory.openSession();
			 employee Employee=session.get(employee.class, 4);
			 System.out.println("data is done"+Employee);
			
			
		}
		catch(HibernateException e) {
			System.out.println(e.getMessage());
		}
		 finally {
			 if(session!=null) {
				 System.out.println("session is closed");
				 session.close();
			 }
			 else {
				 System.out.println("session is not closed");
			 }
			 if(sessionfactory!=null) {
				 System.out.println("session factory is closed");
				 sessionfactory.close();
			 }
			 else {
				 System.out.println("session factory is not closed");
			 }
		 }
	}

	@Override
	public void updateemployeedetails() {
		System.out.println("employeedaoimpl.updateemployeedetails()");
		SessionFactory sessionfactory=null;
		Session session=null;
		Transaction trans=null;
		try {
			Configuration config=new Configuration();
			config.addAnnotatedClass(employee.class);
			config.configure("hibernate.cfg.xml");
			sessionfactory=config.buildSessionFactory();
			 session=sessionfactory.openSession();
			 employee Employee=session.get(employee.class, 3);
			 System.out.println(" before data is updated"+Employee);
			 Employee.setName("varsha");
			 Employee.setAge(23);
			 Employee.setGender("F");
			 Employee.setSalary(25000);
			 trans=session.beginTransaction();
			 session.update(Employee);
			 trans.commit();
			 System.out.println("data is updated sucessfully");
			 	
		}
		catch(HibernateException e) {
			System.out.println(e.getMessage());
			//trans.rollback();
		}
		 finally {
			 if(session!=null) {
				 System.out.println("session is closed");
				 session.close();
			 }
			 else {
				 System.out.println("session is not closed");
			 }
			 if(sessionfactory!=null) {
				 System.out.println("session factory is closed");
				 sessionfactory.close();
			 }
			 else {
				 System.out.println("session factory is not closed");
			 }
		 }
		
		
		
		
		
	}

	@Override
	public void deleteemployeedata() {
		System.out.println("employeedaoimpl.deleteemployeedata()");
		SessionFactory sessionfactory=null;
		Session session=null;
		try {
			Configuration config=new Configuration();
			config.addAnnotatedClass(employee.class);
			config.configure("hibernate.cfg.xml");
			sessionfactory=config.buildSessionFactory();
			 session=sessionfactory.openSession();
			 session.beginTransaction();
			 employee Employee=session.get(employee.class, 3);
			 session.delete(Employee);
			 session.getTransaction().commit();
			 System.out.println("data is deleted sucessfully");
			 
			 
			
		}
		catch(HibernateException e) {
			System.out.println(e.getMessage());
		}
		 finally {
			 if(session!=null) {
				 System.out.println("session is closed");
				 session.close();
			 }
			 else {
				 System.out.println("session is not closed");
			 }
			 if(sessionfactory!=null) {
				 System.out.println("session factory is closed");
				 sessionfactory.close();
			 }
			 else {
				 System.out.println("session factory is not closed");
			 }
		 }
		
	}

}
