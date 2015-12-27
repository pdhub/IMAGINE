package com.pritom.cronjob;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class SessionCheckerWithFixedDelay {

	@Scheduled(fixedDelay=5000)
	public void checkSession(){
		 System.out.println("Method executed at every 2 seconds. Current time is :: "+ new Date());
		 logout();
	}
	
	public void logout() {
		HttpServletRequest request =
		        ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes())
		            .getRequest();
		    new SecurityContextLogoutHandler().logout(request, null, null);
    }
}
