package com.indiv.front.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class memberController {

	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String join(HttpServletRequest request, Model model) {
		
		return "member/join";
	}
	
}
