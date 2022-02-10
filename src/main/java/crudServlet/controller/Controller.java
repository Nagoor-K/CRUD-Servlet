package crudServlet.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

import crudServlet.entity.Address;
import crudServlet.entity.Student;
import crudServlet.entity.module.PersistenceModule;

public class Controller {
	@Inject
	private static EntityManagerFactory entityMangerFactory;
	
	private static EntityManager entityManager;
	
	public Controller() {
		Injector injector = Guice.createInjector(new PersistenceModule());
		entityMangerFactory = injector.getInstance(EntityManagerFactory.class);
	}
	
	public Address addAddress(Address address) {
		 entityManager = entityMangerFactory.createEntityManager();
		 entityManager.getTransaction( ).begin( );
	      try {
	         entityManager.persist(address);
	         entityManager.getTransaction( ).commit();
	      } catch (Exception e) {
	         e.printStackTrace(); 
	      } finally {
	         entityManager.close(); 
	      }
		return address;
	}
	public int addStudent(Student s) {
		  entityManager = entityMangerFactory.createEntityManager();
		  entityManager.getTransaction( ).begin( );
	      try {
	         entityManager.persist(s);
	         entityManager.getTransaction( ).commit();
	      } catch (Exception e) {
	         e.printStackTrace(); 
	      } finally {
	    	  entityManager.close(); 
	      }
	    return s.getId();
		
	}
	public Student deleteStudent(int stuId) {
		entityManager = entityMangerFactory.createEntityManager();
		entityManager.getTransaction( ).begin( );
		Student s = null;
		try {
			s = (Student)entityManager.find(Student.class, stuId);
			if(s == null) {
				System.out.println("-- there is no student with id : "+stuId);
				return null;
			}
			entityManager.remove(s);
			entityManager.getTransaction().commit();
		}catch (Exception e) {
	         e.printStackTrace(); 
	      } finally {
	    	  entityManager.close(); 
	      }
		return s;
	}
	public Student viewStudent(int stuId) {
		entityManager = entityMangerFactory.createEntityManager();
		entityManager.getTransaction( ).begin( );
		Student s = null;
		try {
			s = (Student)entityManager.find(Student.class, stuId);
			if(s == null) {
				System.out.println("-- there is no student with id : "+stuId);
				return null;
			}
			return s;
		}catch (Exception e) {
	         e.printStackTrace(); 
	      } finally {
	    	  entityManager.close(); 
	      }
		return s;
	}
}
