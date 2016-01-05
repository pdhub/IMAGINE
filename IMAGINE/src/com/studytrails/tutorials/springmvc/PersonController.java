package com.studytrails.tutorials.springmvc;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PersonController {

	private PersonService personService;

	public PersonService getPersonService() {
		System.out.println("in getPersonService");
		return personService;
	}

	@Autowired
	public void setPersonService(PersonService personService) {
		System.out.println("In setPersonService");
		this.personService = personService;
	}

	@RequestMapping("/allpersons")
	public String showPersonListPage(Map<String, Object> model) {
		System.out.println("In showPersonListPage");
		model.put("persons", getPersonService().fetchAllPersons());
		return "person_list";
	}

}