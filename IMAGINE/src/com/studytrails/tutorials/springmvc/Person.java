package com.studytrails.tutorials.springmvc;

public class Person {

	private String name;
	private Integer age;

	public Person() {

	}

	public String getName() {
		return name;
	}

	public Person(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

}