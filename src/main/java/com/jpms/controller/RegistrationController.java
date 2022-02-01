package com.jpms.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jpms.dto.UserDTO;
import com.jpms.entity.User;
import com.jpms.service.UserService;

@Controller
@RequestMapping("/register")
public class RegistrationController {

	@Autowired
	private UserService userService;

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {

		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

	@GetMapping("/showRegistrationForm")
	public ModelAndView showRegistrationPage(ModelAndView mv) {
		mv.addObject("userDTO", new UserDTO());
		mv.setViewName("registration-form");

		return mv;
	}

	@PostMapping("/processRegistrationForm")
	public ModelAndView processRegistrationForm(@Valid @ModelAttribute("userDTO") UserDTO userDTO,
			BindingResult theBindingResult, ModelAndView mv) {

		mv = new ModelAndView("registration-form");
		// form validation
		if (theBindingResult.hasErrors()) {
			return mv;
		}

		// check the database if user already exists
		User userByName = userService.findByUserName(userDTO.getUserName());

		if (userByName != null) {
			mv.addObject("userDTO", userDTO);
			mv.addObject("registrationError", "User name already exists.");
			return mv;
		}

		// check the database if user already exists
		User userByEmail = userService.findByEmail(userDTO.getEmail());

		if (userByEmail != null) {
			mv.addObject("userDTO", userDTO);
			mv.addObject("registrationError", "Account already exists with given email");
			return mv;
		}
		// create user account //
		userService.save(userDTO);
		System.out.println("not saved");
		mv.setViewName("registration-confirmation");

		return mv;
	}
}
