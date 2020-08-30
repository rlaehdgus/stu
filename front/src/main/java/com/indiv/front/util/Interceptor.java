package com.indiv.front.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

public class Interceptor implements HandlerInterceptor {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {
		HttpSession session = request.getSession();
		Object sessMember = session.getAttribute("sessMember");
		boolean result = true;
		
		if(sessMember == null) {
			response.sendRedirect("/main");
			result = false;
		} 
		
		if(request.getRequestURI().indexOf("/info") != -1) {
			if(session.getAttribute("passCnt") == null) {
				response.sendRedirect("/mypage/passChk");
				result = false;
			}
		}
		
		return result;
	}
}