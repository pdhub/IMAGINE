package com.pritom.spring.service;

import org.springframework.transaction.annotation.Transactional;

import com.pritom.spring.dao.LoginDao;

public class LoginServiceImpl implements LoginService {

	private LoginDao loginDao;
	
	public void setLoginDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}
	
	@Override
	@Transactional
	public String getExamInformation() {
		return loginDao.getExamInformation();
	}



}
