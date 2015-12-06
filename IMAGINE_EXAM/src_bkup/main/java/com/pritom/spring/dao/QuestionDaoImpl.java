package com.pritom.spring.dao;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pritom.spring.model.Questions;
import com.pritom.spring.model.UserAns;

public class QuestionDaoImpl implements QuestionsDAO {

	private static final Logger logger = LoggerFactory.getLogger(PersonDAOImpl.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public Questions getQuestionById(int id) {
		Session session = this.sessionFactory.getCurrentSession();

		Questions q = (Questions) session.load(Questions.class, new Integer(id));

		logger.info("Question loaded successfully, Question details=" + q);

		return q;
	}

	@Override
	public List<Questions> getQuestionList() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Questions> questionsList = session.createQuery("from Questions").list();
        for(Questions q : questionsList){
            logger.info("Questions List::"+q);
        }
        return questionsList;
		
	}

	@Override
	public Integer evaluateAnswers(String userId) {
		
		Session session = this.sessionFactory.getCurrentSession();
		
		Query query = session.createSQLQuery(
				"SELECT COUNT(USER_ANS.QUES_ID) FROM USER_ANS INNER JOIN questions q "
				+ " ON USER_ANS.QUES_ID = q.QuestionId INNER JOIN answers a ON q.QuestionId = a.QuestionId "
				+ " AND a.is_correct_ans = 'Y' AND USER_ANS.ANS_ID = a.ANSId AND USER_ANS.USER_Id= :userId")
				.setParameter("userId", userId);
		
		List result = query.list();
		if(result!=null && result.size()>0){
			BigInteger num = (BigInteger) result.get(0);
			return num.intValue();
		}
		return 0;
	}

	@Override
	public void saveUserAnswers(String userId, Map<Integer, Integer> quesIdAnsId) {
		
		Session session = this.sessionFactory.getCurrentSession();
		
		Set<Map.Entry<Integer, Integer>> entrySet = quesIdAnsId.entrySet(); 
		for (Map.Entry<Integer, Integer> entry : entrySet) { 
			UserAns userAns = new UserAns();
			userAns.setUserId(userId);
			userAns.setQuestionId(entry.getKey());
			userAns.setAnsId(entry.getValue());
			session.save(userAns);
		}
		
	}

}
