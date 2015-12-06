package com.pritom.spring.model;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="QUESTIONS")
public class Questions {

	@Id
	@Column(name="QuestionId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int questionId;
	
	@Column(name="Question")
	private String question;
	
	
	@OneToMany(mappedBy="question",fetch = FetchType.EAGER)
	private Set<Answers> answers;
	
	//This is required for hibernate
	public Questions(){
		
	}
	
	public Questions(int questionId, String question, Set<Answers> answers) {
		super();
		this.questionId = questionId;
		this.question = question;
		this.answers = answers;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	
	public Set<Answers> getAnswers() {
		return answers;
	}

	public void setAnswers(Set<Answers> answers) {
		this.answers = answers;
	}
	
	
	
	
	
	
	
	
}
