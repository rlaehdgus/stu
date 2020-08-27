package com.indiv.front.member.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String register(memberVO memberVO) throws Exception {
		
		// 값 체크
		if(memberVO != null) {
			memberService.register(memberVO);
		}
		
		return "redirect: /login";
	}
	
	/**
	 * 로그인 Proc
	 * @param memberVO
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/loginChk", method=RequestMethod.POST)
	public String loginChk(memberVO memberVO, HttpSession session) throws Exception {
		Map<String, Object> map = null;
		String returnUrl = "";
		
		// 값 체크
		if(memberVO != null) {
			map = memberService.loginChk(memberVO);
			
			// 회원 정보 세션 값 삭제처리
			if(session.getAttribute("member") != null) {
				session.removeAttribute("member");
			}
			
			// 회원 정보 확인 및 세션 추가
			if(map != null) {
				session.setAttribute("member", map);
				returnUrl = "redirect: /main";
			} else {
				returnUrl = "redirect: /login";
			}
		}
		
		return returnUrl;
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
		if(session.getAttribute("member") != null) {
			session.removeAttribute("member");
			returnUrl = "redirect: /main";
		} else {
			returnUrl = "redirect: /login";
		}
		
		return returnUrl;
	}
}
