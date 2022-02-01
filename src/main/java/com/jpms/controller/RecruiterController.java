package com.jpms.controller;

import java.util.Optional;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jpms.entity.Recruiter;
import com.jpms.entity.User;
import com.jpms.exception.RecruiterNotFoundException;
import com.jpms.service.RecruiterService;
import com.jpms.service.UserService;

@Controller
@RequestMapping("/recruiters")
public class RecruiterController {
	@Autowired
	private RecruiterService recruiterService;

	@Autowired
	private UserService userService;

	// Recruiter Home Page
	@GetMapping("/{recruiterId}")
	public ModelAndView homePage(HttpSession httpSession, @PathVariable Long recruiterId, ModelAndView mv) {

		User user = (User) httpSession.getAttribute("user");
		String userName = user.getUserName();
		user = userService.findByUserName(userName);
		mv.addObject("user", user);
		mv.addObject("recruiterId", recruiterId);
		mv = new ModelAndView("recruiter_home");
		return mv;
	}

	// Showing Add Profile Form

	@GetMapping("/showProfileForm")
	public ModelAndView showProfileForm(ModelAndView mv, HttpSession httpSession) {
		Recruiter recruiter = recruiterService.findByUserId(((User) httpSession.getAttribute("user")).getId());

		if (recruiter != null) {
			mv.setViewName("redirect:/recruiters/" + recruiter.getId());
			return mv;
		}
		mv.setViewName("recruiter_create_form");
		recruiter = new Recruiter();
		mv.addObject("recruiter", recruiter);
		return mv;
	}

	// Showing Update Profile Form
	@GetMapping("/{recruiterId}/showUpdateProfileForm")
	public ModelAndView showUpdateProfileForm(HttpSession httpSession, @PathVariable Long recruiterId,
			ModelAndView mv) {
		mv = new ModelAndView("recruiter_create_form");
		Optional<Recruiter> recruiterOptional = recruiterService.findById(recruiterId);
		if (!recruiterOptional.isPresent()) {
			throw new RecruiterNotFoundException("Recruiter Id not valid");
		}
		mv.addObject("recruiter", recruiterOptional.get());
		return mv;
	}

	// processing Recruiter Profile ADD or UPDATEs
	@PostMapping("/save")
	public ModelAndView processRecruiterProfileForm(HttpSession session, @Valid @ModelAttribute Recruiter recruiter,
			BindingResult theBindingResult, ModelAndView mv) {
		// form validation
		if (theBindingResult.hasErrors()) {
			mv.setViewName("recruiter_create_form");
			return mv;
		}

		// For ADD : set recruiter-user relation
		if (recruiter.getId() == 0L) {
			User user = (User) session.getAttribute("user");
			user = userService.findByUserName(user.getUserName());
			recruiter.setUser(user);
		}

		// here save manages both ADD or UPDATE
		mv.addObject("recruiter", recruiterService.save(recruiter));
		mv.setViewName("redirect:/recruiters/" + recruiter.getId());

		return mv;

	}

}
