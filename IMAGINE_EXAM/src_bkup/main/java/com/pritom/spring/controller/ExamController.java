package com.pritom.spring.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pritom.spring.model.EnvBean;
import com.pritom.spring.model.Questions;
import com.pritom.spring.service.QuestionService;
import com.pritom.spring.view.ExamResultView;
import com.pritom.spring.view.UserExamView;

@Controller
public class ExamController {

	private QuestionService questionService;
	
	@Autowired(required=true)
    @Qualifier(value="questionService")
	public void setQuestionService(QuestionService questionService) {
		this.questionService = questionService;
	}
	
	@RequestMapping(value = "/questions", method = RequestMethod.GET)
    public String listQuestions(HttpServletRequest req,Model model) {
        
        /*List<Questions> questionList = this.questionService.getQuestionsList();
        model.addAttribute("QuestionsList", questionList);
        
        //Now create the question selection list here
        List<Integer> selectionList = new ArrayList<Integer>();
        for (Questions question : questionList) {
        	selectionList.add(question.getQuestionId());
        }
       
        model.addAttribute("selectionList", selectionList);*/
                       
        return getQuestion(req, model);
    }
	
		
	@RequestMapping(value = "/getNewQuestion",method = RequestMethod.POST)
	public String getQuestion(HttpServletRequest req, Model model){
		
		String id = req.getParameter("theRadioGroupName");
		if(id==null || id=="")
			id="1";
		
		model.addAttribute("currentquestion", new Questions()); 
		model.addAttribute("currentquestion", this.questionService.getQuestionById(Integer.valueOf(id)));
		
		UserExamView userExamView = new UserExamView();
		
		if(userExamView.getNumQuestions()==null)
        	userExamView.setNumQuestions(this.questionService.getQuestionsList().size());
        userExamView.setCurrentQuestion(this.questionService.getQuestionById(Integer.valueOf(id)));
        
        model.addAttribute("currentquestion", userExamView.getCurrentQuestion());
        
        model.addAttribute("userExamView", userExamView);
		
		return "Questions";
		//return "";
	}
	
	
	@RequestMapping(value = "/submitCurrentAns",method = RequestMethod.POST)
	public String saveCurrentAns(@ModelAttribute("userExamView") UserExamView userExamView,HttpServletRequest req, Model model){
		
		String ansid = req.getParameter("answerId");
		
		Integer questionId = Integer.valueOf(req.getParameter("questionId"));
		
		Integer numQuestions = Integer.valueOf(req.getParameter("numQuestions"));
		
		userExamView.getQuesIdAnsId().put(questionId, Integer.valueOf(ansid));
		
	
		if(questionId<numQuestions)
			userExamView.setCurrentQuestion(this.questionService.getQuestionById(Integer.valueOf(questionId+1)));
		else{
			this.questionService.saveUserAnswers("PRITOM", userExamView.getQuesIdAnsId());
			int correctAns = this.questionService.evaluateAnswers("PRITOM");
			
			ExamResultView examResultView = new ExamResultView();
			examResultView.setUserId("Pritom");
			examResultView.setResult(correctAns);
			model.addAttribute("examResultView", examResultView);
			return "examResults";
		}
       		
		return "Questions";
		//return "";
	}
	
	
	@ModelAttribute("questionNbrList")
	public List<String> populateQuestionNumberList() {
		
		//Data referencing for web framework checkboxes
		List<String> questionNbrList = new ArrayList<String>();
		questionNbrList.add("Spring MVC");
		questionNbrList.add("Struts 1");
		questionNbrList.add("Struts 2");
		questionNbrList.add("JSF");
		questionNbrList.add("Apache Wicket");
		
		return questionNbrList;
	}
	
	@ModelAttribute
	@RequestMapping(value = "/env", method = RequestMethod.GET)
	public ModelAndView env(@ModelAttribute("envBean") EnvBean envBean){

	    //logger.info("parameter is " + envBean.getEnv());
		 return new ModelAndView("Selection", "envBean", envBean); 

	}
	
	
}
