package com.indiv.front.member.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.indiv.front.vo.memberVO;
import com.indiv.front.member.service.mypageService;;

@Controller
@RequestMapping(value = "/mypage")
public class mypageController {
	
	@Autowired
	private mypageService mypageService;
	
	/**
	 * 마이페이지 > 비밀번호 재확인
	 * @return
	 */
	@RequestMapping(value = "/passChk", method = RequestMethod.GET)
	public String passChk() {
		
		return "member/passChk";
	}
	
	/**
	 * 마이페이지 > 비밀번호 재확인 Proc
	 * @param memberVO
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/passChkProc", method = RequestMethod.POST)
	public ModelAndView passChkProc(memberVO memberVO, HttpServletRequest request) throws Exception {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		resultMap = mypageService.passChk(request, memberVO);
		
		return new ModelAndView("jsonView", resultMap);
	}
	
	/**
	 * 마이페이지 > 내정보
	 * @return
	 */
	@RequestMapping(value = "/info", method = RequestMethod.GET)
	public String info() {
		
		return "member/info";
	}
	
	@RequestMapping(value = "/editInfo", method = RequestMethod.POST)
	public ModelAndView editInfo(memberVO memberVO) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		
		
		return new ModelAndView("jsonView", resultMap);
	}
}
