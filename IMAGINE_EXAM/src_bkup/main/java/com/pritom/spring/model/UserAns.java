package com.pritom.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USER_ANS")
public class UserAns {
	
	@Id
	@Column(name="USER_ANS_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;
	
	@Column(name="USER_ID")
	private String userId;
	
	@Column(name="QUES_ID")
	private Integer questionId;
	
	@Column(name="ANS_ID")
	private Integer ansId;
		
	public UserAns() {
		
	}
	
	public UserAns(String id, String userId, Integer questionId, Integer ansId) {
		super();
		this.id = id;
		this.userId = userId;
		this.questionId = questionId;
		this.ansId = ansId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Integer getQuestionId() {
		return questionId;
	}
	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}
	public Integer getAnsId() {
		return ansId;
	}
	public void setAnsId(Integer ansId) {
		this.ansId = ansId;
	}
	
	

}
