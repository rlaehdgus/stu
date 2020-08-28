package com.indiv.front.member.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indiv.front.member.dao.memberDao;
import com.indiv.front.util.cryptoUtil;
import com.indiv.front.vo.memberVO;

@Service
public class memberServiceImpl implements memberService {
	
	@Autowired
	private memberDao memberDao;

	/**
	 * 회원가입 Proc
	 * @return 
	 */
	@Override
	public Map<String, Object> register(HttpServletRequest request, memberVO memberVO) throws Exception {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		String result = "FAIL";
		String message = "";
		
		// 입력 정보가 있을 경우
		if(memberVO != null) {
			if(request.getSession().getAttribute("sessMember") != null) {
				request.getSession().removeAttribute("sessMember");
				
				message = "이미 로그인이 되어있습니다. 로그아웃하고 다시 진행해주세요.";
				
				resultMap.put("RESULT", result);
				resultMap.put("MESSAGE", message);
				
				return resultMap;
			}
			
			// 비밀번호 암호화
			memberVO.setPass(cryptoUtil.sha256(memberVO.getPass()));
			
			memberDao.register(memberVO);
			
			result = "SUCCESS";
			message = "회원가입에 성공하셨습니다.";
		} else {
			message = "회원가입에 실패하셨습니다. 입력하신 정보를 다시 확인해주세요.";
		}
		
		resultMap.put("RESULT", result);
		resultMap.put("MESSAGE", message);
		
		return resultMap;
	}

	/**
	 * 로그인 Proc
	 */
	@Override
	public Map<String, Object> loginChk(HttpServletRequest request, memberVO memberVO) throws Exception {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		String result = "FAIL";
		String message = "";
		
		// 입력 정보가 있을 경우
		if(memberVO != null) {
			// 회원 정보 세션 값 삭제처리
			if(request.getSession().getAttribute("sessMember") != null) {
				request.getSession().removeAttribute("sessMember");
				
				message = "이미 로그인 하셨습니다. 로그아웃 후 다시 로그인해주새요.";
				
				resultMap.put("RESULT", result);
				resultMap.put("MESSAGE", message);
				
				return resultMap;
			}

			// 비밀번호 암호화
			memberVO.setPass(cryptoUtil.sha256(memberVO.getPass()));
			
			resultMap = memberDao.loginChk(memberVO);
			
			if(resultMap != null) {
				request.getSession().setAttribute("sessMember", resultMap);
				
				result = "SUCCESS";
				message = "로그인 성공하였습니다.";
			} else {
				message = "로그인 실패하셨습니다. 다시 시도해주세요.";
			}
		}
		
		resultMap.put("RESULT", result);
		resultMap.put("MESSAGE", message);
		
		return resultMap;
	}

}
