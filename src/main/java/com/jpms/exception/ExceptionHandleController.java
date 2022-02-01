package com.jpms.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionHandleController {

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {

		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

	@ExceptionHandler(Exception.class)
	public ModelAndView globalException(HttpServletRequest req, Exception ex) {
		ModelAndView mv = new ModelAndView("global-error-page");
		ex.printStackTrace();
		mv.addObject("exception", ex.getLocalizedMessage() + " at " + req.getRequestURL());

		return mv;

	}

}
