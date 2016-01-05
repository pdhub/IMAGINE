package com.pritom.spring.dao;

import java.math.BigInteger;
import java.util.List;

import org.hibernate.Query;

public class LoginDaoImpl extends PDBaseDaoImpl implements LoginDao{

	@Override
	public String getExamInformation() {
		String examInfoQuery = "select exam_Desc from exam_info";
		Query query = getSessionFactory().getCurrentSession().createSQLQuery(examInfoQuery);
		List result = query.list();
		if(result!=null && result.size()>0){
			String examDesc = (String) result.get(0);
			return examDesc;
		}
		else 
			return "";
				
	}

	
}
