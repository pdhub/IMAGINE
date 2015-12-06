package com.pritom.spring.service;

import java.util.List;
import java.util.Map;

import com.pritom.spring.model.Questions;

public interface QuestionService {

	public Questions getQuestionById(int id);

	public List<Questions> getQuestionsList();

	public Integer evaluateAnswers(String userId);

	public void saveUserAnswers(String userId, Map<Integer, Integer> quesIdAnsId);
}
