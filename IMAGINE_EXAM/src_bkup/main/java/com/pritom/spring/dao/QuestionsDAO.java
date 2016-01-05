package com.pritom.spring.dao;

import java.util.List;
import java.util.Map;

import com.pritom.spring.model.Questions;

public interface QuestionsDAO {

	public Questions getQuestionById(int id);

	public List<Questions> getQuestionList();

	public Integer evaluateAnswers(String userId);

	public void saveUserAnswers(String userId,Map<Integer, Integer> quesIdAnsId);
}
