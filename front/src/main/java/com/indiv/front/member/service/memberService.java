package com.indiv.front.member.service;

import java.util.Map;

import com.indiv.front.vo.memberVO;

public interface memberService {

	// 회원가입 Proc
	void register(memberVO memberVO) throws Exception;
	
	// 로그인 Proc 
	Map<String, Object> loginChk(memberVO memberVO) throws Exception;
}
