package com.scp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.scp.service.Login;

@Controller
public class LoginController {
	@RequestMapping("/GetLogin")
	public String getLogin() {
		return "login";
	}

	@RequestMapping("/loginAuth")
	public ModelAndView loginAuth(@ModelAttribute Login login) {
		ModelAndView model;
		if ("Abc".equals(login.getUserName()) && "pass".equals(login.getPassword())) {
			String user = login.getUserName();
			model = new ModelAndView("success");
			model.addObject("user", login);
			return model;
		} else {
			String errorMsg = "Please fill the correct user and Pass";
			model = new ModelAndView("login");
			model.addObject("errorMsg", errorMsg);
			return model;
		}
	}
}
