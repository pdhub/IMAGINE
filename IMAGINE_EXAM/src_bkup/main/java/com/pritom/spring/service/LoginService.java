package com.pritom.spring.service;

import org.springframework.transaction.annotation.Transactional;

public interface LoginService {

	@Transactional
	public String getExamInformation();
}
