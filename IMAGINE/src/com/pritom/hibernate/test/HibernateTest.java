package com.pritom.hibernate.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.pritom.hibernate.entity.Customer;

public class HibernateTest {

	public static void main(String[] args) {
		
		Configuration configuration = new Configuration().configure();
        ServiceRegistryBuilder registry = new ServiceRegistryBuilder();
        registry.applySettings(configuration.getProperties());
        ServiceRegistry serviceRegistry = registry.buildServiceRegistry();
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
         
        // opens a new session from the session factory
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        // persists two new Contact objects
        Customer cust1 = new Customer();
        cust1.setId(12);
        cust1.setName("Gritom");
        
        session.persist(cust1);
       
        session.save(cust1);
        
        session.getTransaction().commit();
        
        
       /* String hql = "SELECT customer.Name FROM Customer customer";
        Query query = session.createQuery(hql);
        List<String> results = query.list();
        System.out.println(results);*/
        session.close();
	}

}
