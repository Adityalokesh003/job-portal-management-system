package com.jpms.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.jpms.entity.Role;
import com.jpms.entity.User;
import com.jpms.service.UserService;

@Component
@SessionAttributes("user")
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	@Autowired
	// @Lazy
	private UserService userService;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		String userName = authentication.getName();
		User user = userService.findByUserName(userName);
		Role role = (Role) user.getRoles().toArray()[0];

		// now place in the session //
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(600);
		session.setAttribute("user", user);

		// forward to home page
		String redirectUrl = "";
		if (role.getName().equals("ROLE_JOB_SEEKER")) {
			redirectUrl = request.getContextPath() + "/jobseekers/home";

		} else if (role.getName().equals("ROLE_RECRUITER")) {
			redirectUrl = request.getContextPath() + "/recruiters/showProfileForm";
		}

		response.sendRedirect(redirectUrl);
	}

}
