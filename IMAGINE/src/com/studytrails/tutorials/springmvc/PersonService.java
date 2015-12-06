package com.studytrails.tutorials.springmvc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class PersonService {

	private List<Person> persons = new ArrayList<Person>();

	public PersonService() {
		System.out.println("In PersonService");
		persons.add(new Person("Alba", 10));
		persons.add(new Person("Beth", 20));
		persons.add(new Person("Cathy", 30));
	}

	public List<Person> fetchAllPersons() {
		return persons;
	}
}