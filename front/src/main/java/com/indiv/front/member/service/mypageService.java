package com.indiv.front.member.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.indiv.front.vo.memberVO;

public interface mypageService {

	public Map<String, Object> passChk(HttpServletRequest request, memberVO memberVO) throws Exception;
}
