package com.pritom.spring.view;

import org.hibernate.validator.constraints.NotEmpty;

public class LoginBean {
	@NotEmpty(message = "Please enter your username.")
	private String username;

	@NotEmpty(message = "Please enter your password.")
	//@Size
	private String password;

	private String examDescription;

	public String getPassword() {
		return this.password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getExamDescription() {
		return examDescription;
	}

	public void setExamDescription(String examDescription) {
		this.examDescription = examDescription;
	}

}
