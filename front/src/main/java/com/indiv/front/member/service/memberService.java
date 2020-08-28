package com.indiv.front.member.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.indiv.front.vo.memberVO;

public interface memberService {

	// 회원가입 Proc
	Map<String, Object> register(HttpServletRequest request, memberVO memberVO) throws Exception;
	
	// 로그인 Proc 
	Map<String, Object> loginChk(HttpServletRequest request, memberVO memberVO) throws Exception;
}
