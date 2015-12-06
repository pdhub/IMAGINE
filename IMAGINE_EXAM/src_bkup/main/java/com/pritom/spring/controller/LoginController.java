package com.pritom.spring.controller;

import javax.inject.Qualifier;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pritom.spring.delegate.LoginDelegate;
import com.pritom.spring.service.LoginService;
import com.pritom.spring.view.ExamDescView;
import com.pritom.spring.view.LoginBean;

@Controller
public class LoginController {

	/*
	 * @RequestMapping("/login") public ModelAndView getLoginForm(
	 * 
	 * @RequestParam(required = false) String authfailed, String logout, String
	 * denied) { String message = ""; if (authfailed != null) { message =
	 * "Invalid username of password, try again !"; } else if (logout != null) {
	 * message = "Logged Out successfully, login again to continue !"; } else if
	 * (denied != null) { message = "Access denied for this user !"; } return
	 * new ModelAndView("login", "message", message); }
	 * 
	 * @RequestMapping("user") public String geUserPage() { return "user"; }
	 * 
	 * @RequestMapping("admin") public String geAdminPage() { return "admin"; }
	 * 
	 * @RequestMapping("403page") public String ge403denied() { return
	 * "redirect:login?denied"; }
	 */

	@Autowired
	private LoginDelegate loginDelegate;

	private LoginService loginService;

	@Autowired(required = true)
	@org.springframework.beans.factory.annotation.Qualifier(value = "loginService")
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET) public
	  ModelAndView displayLogin(HttpServletRequest request, HttpServletResponse
	  response, Model model){
	  
	  ModelAndView modelandview = new ModelAndView("login");
	  
	  LoginBean loginBean = new LoginBean();
	  
	  ExamDescView examDesc = new ExamDescView();
	  examDesc.setDesc(loginService.getExamInformation());
	  
	  //loginBean.setExamDescription(loginService.getExamInformation());
	  
	  //request.getSession().setAttribute("examdescription",
	  //loginService.getExamInformation();
	  
	  modelandview.addObject("examDesc", examDesc);
	  
	  modelandview.addObject("loginBean", loginBean);
	  
	  return modelandview;
	  
	  }

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView executeLogin(
			@Valid @ModelAttribute("loginBean") LoginBean loginBean,
			BindingResult result, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {

		ModelAndView model = null;

		String desc = loginBean.getExamDescription();

		try {

			if (result.hasErrors()) {
				model = new ModelAndView("login");

				model.addObject("loginBean", loginBean);

				return model;
			}

			boolean isValidUser = loginDelegate.isValidUser(
					loginBean.getUsername(), loginBean.getPassword());

			if (isValidUser) {

				System.out.println("User Login Successful");

				request.setAttribute("loggedInUser", loginBean.getUsername());

				session.setAttribute("login", model);

				model = new ModelAndView("ListQuestions");

			} else {

				model = new ModelAndView("login");

				model.addObject("loginBean", loginBean);

				request.setAttribute("message", "Invalid credentials!!");

			}

		}

		catch (Exception e) {
			e.printStackTrace();
		}

		return model;

	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login.jsp";
	}

}
