package com.pritom.spring.dao;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PDBaseDaoImpl {

	private static final Logger logger = LoggerFactory.getLogger(PDBaseDaoImpl.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
