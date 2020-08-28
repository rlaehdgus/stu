package com.indiv.front.member.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.indiv.front.member.service.memberService;
import com.indiv.front.vo.memberVO;

@Controller
public class memberController {

	@Autowired
	private memberService memberService;

	/**
	 * 로그인&회원가입 페이지
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String join(HttpServletRequest request, Model model) {
		
		return "member/login";
	}
	
	/**
	 * 회원가입 Proc
	 * @param memberVO
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public ModelAndView register(memberVO memberVO, HttpServletRequest request) throws Exception {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		resultMap = memberService.register(request, memberVO);
		
		return new ModelAndView("jsonView", resultMap);
	}
	
	/**
	 * 로그인 Proc
	 * @param memberVO
	 * @param session
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/loginChk", method=RequestMethod.POST)
	public ModelAndView loginChk(memberVO memberVO, HttpSession session, HttpServletRequest request) throws Exception {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		resultMap = memberService.loginChk(request, memberVO);
		
		return new ModelAndView("jsonView", resultMap);
	}
	
	/**
	 * 로그아웃 Proc
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpSession session) {
		String returnUrl = "";
		
		// 세션 값이 있으면 세션 삭제
		if(session.getAttribute("sessMember") != null) {
			session.removeAttribute("sessMember");
			returnUrl = "redirect: /main";
		} else {
			returnUrl = "redirect: /login";
		}
		
		return returnUrl;
	}
}
