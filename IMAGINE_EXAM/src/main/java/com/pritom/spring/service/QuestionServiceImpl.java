package com.pritom.spring.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pritom.spring.dao.QuestionsDAO;
import com.pritom.spring.model.Questions;
@Service
public class QuestionServiceImpl implements QuestionService {
	
	private QuestionsDAO questionDao;
	
	public void setQuestionDao(QuestionsDAO questionDao) {
		this.questionDao = questionDao;
	}


	@Override
	@Transactional
	public Questions getQuestionById(int id) {
		return this.questionDao.getQuestionById(id);
	}


	@Override
	@Transactional
	public List<Questions> getQuestionsList() {
		return this.questionDao.getQuestionList();
	}


	@Override
	@Transactional
	public void saveUserAnswers(String userId, Map<Integer, Integer> quesIdAnsId) {
		this.questionDao.saveUserAnswers(userId,quesIdAnsId);
		
	}
	
	@Override
	@Transactional
	public Integer evaluateAnswers(String userId) {
		return this.questionDao.evaluateAnswers(userId);
	}


}
