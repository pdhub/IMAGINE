package com.pritom.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ANSWERS")
public class Answers {

	@Id
	@Column(name="ANSID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="ANS")
	private String answer;
	
	@Column(name="IS_CORRECT_ANS")
	private String isCorrectAns;
	
	@ManyToOne
	@JoinColumn(name="QUESTIONID", nullable=false)
	private Questions question;
	
	public Answers(){
		
	}
	
	public Answers(int id, String answer, String isCorrectAns,
			Questions question) {
		super();
		this.id = id;
		this.answer = answer;
		this.isCorrectAns = isCorrectAns;
		this.question = question;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getIsCorrectAns() {
		return isCorrectAns;
	}

	public void setIsCorrectAns(String isCorrectAns) {
		this.isCorrectAns = isCorrectAns;
	}

	public Questions getQuestion() {
		return question;
	}

	public void setQuestion(Questions question) {
		this.question = question;
	}
	
	
	
}
