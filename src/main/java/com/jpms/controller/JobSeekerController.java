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

import com.jpms.entity.JobSeeker;
import com.jpms.entity.User;
import com.jpms.exception.JobSeekerNotFoundException;
import com.jpms.service.JobSeekerService;
import com.jpms.service.JobService;
import com.jpms.service.UserService;

@Controller
@RequestMapping("/jobseekers")
public class JobSeekerController {

	@Autowired
	private JobSeekerService jobSeekerService;
	@Autowired
	private UserService userService;

	@Autowired
	JobService jobService;

	@GetMapping("/home")
	public ModelAndView showHomePage(HttpSession httpSession, ModelAndView mv) {
		User user = (User) httpSession.getAttribute("user");
		mv.setViewName("jobseeker-home");
		mv.addObject("user", user);
		return mv;
	}

	// Jobseeker Home Page
	@GetMapping("/{jobseekerId}")
	public ModelAndView homePage(HttpSession httpSession, @PathVariable Long jobseekerId, ModelAndView mv) {

		User user = (User) httpSession.getAttribute("user");
		String userName = user.getUserName();
		user = userService.findByUserName(userName);
		mv.addObject("user", user);
		mv.addObject("jobseekerId", jobseekerId);
		mv = new ModelAndView("jobseeker-home");
		return mv;
	}

	// Showing Add Profile Form

	@GetMapping("/showProfileForm")
	public ModelAndView showProfileForm(ModelAndView mv, HttpSession httpSession) {
		JobSeeker jobSeeker = jobSeekerService.findByUserId(((User) httpSession.getAttribute("user")).getId());

		if (jobSeeker != null) {
			mv.setViewName("redirect:/jobseekers/" + jobSeeker.getId());
			return mv;
		}
		mv.setViewName("jobseeker/jobseeker_create_form");
		jobSeeker = new JobSeeker();
		mv.addObject("jobSeeker", jobSeeker);
		return mv;
	}

	// Showing Update Profile Form
	@GetMapping("/{jobseekerId}/showUpdateProfileForm")
	public ModelAndView showUpdateProfileForm(HttpSession httpSession, @PathVariable Long jobseekerId,
			ModelAndView mv) {
		mv = new ModelAndView("jobseeker/jobseeker_create_form");
		Optional<JobSeeker> jobseekerOptional = jobSeekerService.findById(jobseekerId);
		if (!jobseekerOptional.isPresent()) {
			throw new JobSeekerNotFoundException("Jobseeker not found");
		}
		mv.addObject("jobSeeker", jobseekerOptional.get());
		return mv;
	}

	// processing Jobseeker Profile ADD or UPDATEs
	@PostMapping("/save")
	public ModelAndView processJobJeekerProfileForm(HttpSession session, @Valid @ModelAttribute JobSeeker jobSeeker,
			BindingResult theBindingResult, ModelAndView mv) {
		// form validation
		if (theBindingResult.hasErrors()) {
			mv.setViewName("jobseeker/jobseeker_create_form");
			return mv;
		}

		User user = (User) session.getAttribute("user");
		long userId = user.getId();

		// For ADD : set jobSeeker-user relation
		if (jobSeeker.getId() == 0L) {

			user = userService.findByUserName(user.getUserName());
			jobSeeker.setUser(user);
		}

		// here save manages both ADD or UPDATE

		mv.addObject("jobseeker", jobSeekerService.save(jobSeeker, userId));
		// jobSeeker.setUser((User) session.getAttribute("user"));
		System.out.println(jobSeeker);
		mv.setViewName("redirect:/jobseekers/" + jobSeeker.getId());

		return mv;

	}

	@GetMapping("/jobs")
	public ModelAndView findJobs(ModelAndView mv) {
		jobService.findAll();

		return mv;
	}

}
