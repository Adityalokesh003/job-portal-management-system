package com.jpms.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jpms.entity.Job;
import com.jpms.exception.JobNotFoundException;
import com.jpms.service.JobService;

@Controller
@RequestMapping("/recruiters/{recruiterId}/jobs")
public class JobController {

	@Autowired
	private JobService jobService;

	// Find All Jobs
	@GetMapping("/")
	public ModelAndView findAll(@PathVariable Long recruiterId, ModelAndView mv) {
		List<Job> jobs = jobService.findAll();
		mv.addObject("jobs", jobs);
		mv.addObject("recruiterId", recruiterId);
		mv.setViewName("recruiter-jobs");

		return mv;
	}

	// Showing Job ADD Form

	@GetMapping("/showAddForm")
	public ModelAndView showAddJobForm(@PathVariable Long recruiterId, ModelAndView mv) {
		mv.setViewName("recruiter-job-create-form");
		mv.addObject("job", new Job());
		return mv;
	}

	// processing Job Form ADD or UPDATE

	@PostMapping("/add")
	public ModelAndView processJobForm(@PathVariable Long recruiterId, @Valid @ModelAttribute Job job,
			BindingResult bindingResult, ModelAndView mv) {
		mv.setViewName("recruiter-job-create-form");

		if (bindingResult.hasErrors()) {
			mv.addObject("recruiterId", recruiterId);
			return mv;
		}

		jobService.save(job);

		mv.setViewName("redirect:/recruiters/" + recruiterId + "/jobs/");

		return mv;
	}

	// Showing Job Update Form
	@GetMapping("/showUpdateJobForm")
	public ModelAndView showUpdateJobForm(@RequestParam("jobId") Long jobId, @PathVariable Long recruiterId,
			ModelAndView mv) {
		Optional<Job> jobOptional = jobService.findById(jobId);
		if (!jobOptional.isPresent()) {
			throw new JobNotFoundException("No job found for this id");
		}

		Job job = jobOptional.get();
		mv.addObject("job", job);
		mv.addObject("recruiterId", recruiterId);
		mv.setViewName("recruiter-job-update-form");
		return mv;
	}

	// Delete JOB
	@GetMapping("/delete")
	public ModelAndView deleteJob(@RequestParam("jobId") Long jobId, @PathVariable Long recruiterId, ModelAndView mv) {
		jobService.remove(jobId);

		mv.setViewName("redirect:/recruiters/" + recruiterId + "/jobs/");

		return mv;
	}

	// Publish or unpublish jobs
	@GetMapping("/publish")
	public ModelAndView togglePublish(@RequestParam("jobId") Long jobId, @PathVariable Long recruiterId,
			ModelAndView mv) {
		jobService.togglePublish(jobId);

		mv.setViewName("redirect:/recruiters/" + recruiterId + "/jobs/");

		return mv;
	}

}
