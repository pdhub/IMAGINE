package com.pritom.spring.view;

import java.util.HashMap;
import java.util.Map;

import com.pritom.spring.model.Questions;

public class UserExamView {

	private Questions currentQuestion;
	private Integer numQuestions;
	private Integer selectedAnsId;
	private static Map<Integer, Integer> quesIdAnsId = new HashMap<Integer, Integer>();
		
	public static Map<Integer, Integer> getQuesIdAnsId() {
		return quesIdAnsId;
	}
	public static void setQuesIdAnsId(Map<Integer, Integer> quesIdAnsId) {
		UserExamView.quesIdAnsId = quesIdAnsId;
	}
	public Questions getCurrentQuestion() {
		return currentQuestion;
	}
	public void setCurrentQuestion(Questions currentQuestion) {
		this.currentQuestion = currentQuestion;
	}
	public Integer getSelectedAnsId() {
		return selectedAnsId;
	}
	public void setSelectedAnsId(Integer selectedAnsId) {
		this.selectedAnsId = selectedAnsId;
	}
	
	public Integer getNumQuestions() {
		return numQuestions;
	}
	public void setNumQuestions(Integer numQuestions) {
		this.numQuestions = numQuestions;
	}
				
}
