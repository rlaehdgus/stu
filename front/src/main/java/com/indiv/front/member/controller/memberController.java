package com.indiv.front.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.indiv.front.member.service.memberService;
import com.indiv.front.vo.memberVO;

@Controller
public class memberController {

	@Autowired
	private memberService memberService;

	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String join(HttpServletRequest request, Model model) {
		
		return "member/join";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String register(memberVO memberVO, HttpServletRequest request) {
		
		// 값 체크
		if(memberVO != null) {
			memberService.register(memberVO);
		}
		
		return "redirect: /join";
	}
}
