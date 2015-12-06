package com.pritom.spring.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pritom.spring.delegate.LoginDelegate;
import com.pritom.spring.model.UserBean;
import com.pritom.spring.view.LoginBean;

@Controller
public class LoginController

{
	@Autowired
	private LoginDelegate loginDelegate;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView displayLogin(HttpServletRequest request,
			HttpServletResponse response){

		ModelAndView model = new ModelAndView("login");

		LoginBean loginBean = new LoginBean();

		model.addObject("loginBean", loginBean);

		System.out.println("Returing login page");
		return model;

	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView executeLogin(HttpServletRequest request,
			HttpServletResponse response,
			@ModelAttribute("loginBean") LoginBean loginBean,HttpSession session){

		ModelAndView model = null;

		try{

			boolean isValidUser = loginDelegate.isValidUser(loginBean.getUsername(), loginBean.getPassword());

			if (isValidUser){

				System.out.println("User Login Successful");

				request.setAttribute("loggedInUser", loginBean.getUsername());
								
				session.setAttribute("login", model);

				model = new ModelAndView("ListQuestions");

			}else{

				model = new ModelAndView("login");

				model.addObject("loginBean", loginBean);

				request.setAttribute("message", "Invalid credentials!!");

			}

		}

		catch (Exception e){
			e.printStackTrace();
		}

		return model;

	}
	
	/*******************************************************************************************************
	 * This method will work as a controller to take the user to the page where he can edit his information
	 * Be it both for a buyer or a seller
	 * *****************************************************************************************************/
	
	@RequestMapping(value = "/loginBuyerSeller", method = RequestMethod.POST)
	public ModelAndView validateLoginWebUser(HttpServletRequest request,
			HttpServletResponse response,
			@ModelAttribute("loginBean") LoginBean loginBean,HttpSession session){

		ModelAndView model = null;

		try{

			boolean isValidUser = loginDelegate.isValidUser(loginBean.getUsername(), loginBean.getPassword());

			if (isValidUser){

				System.out.println("User Login Successful");

				request.setAttribute("loggedInUser", loginBean.getUsername());
								
				session.setAttribute("login", model);

				model = new ModelAndView("Questions");

			}else{

				model = new ModelAndView("login");

				model.addObject("loginBean", loginBean);

				request.setAttribute("message", "Invalid credentials!!");

			}

		}

		catch (Exception e){
			e.printStackTrace();
		}

		return model;

	}
	
	
	/*****************************************************************************************
	 * This function will take the user to the new user registration page where he can input his
	 * current location and other details* 
	 * ******************************************************************************************/
	
	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	public ModelAndView registerNewUser(HttpServletRequest request,
			HttpServletResponse response,
			HttpSession session){

		ModelAndView model = null;
		UserBean user = new UserBean();

		model = new ModelAndView("UserRegistration");
		model.addObject("userBean", user);
		return model;

	}
	
	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public ModelAndView saveUserDetails(HttpServletRequest request,
			HttpServletResponse response,
			HttpSession session,@ModelAttribute("userBean") UserBean userBean){

		ModelAndView model = null;
		UserBean user = userBean;
		System.out.println(user.getUserName());

		model = new ModelAndView("login");
		model.addObject("userBean", user);
		return model;

	}
	
	
	 @RequestMapping("/logout")
     public String logout(HttpSession session ) {
        session.invalidate();
        return "redirect:/login.jsp";
     }

}
