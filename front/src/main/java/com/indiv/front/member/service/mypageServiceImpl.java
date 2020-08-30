package com.indiv.front.member.service;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indiv.front.member.dao.mypageDao;
import com.indiv.front.util.cryptoUtil;
import com.indiv.front.vo.memberVO;

@Service
public class mypageServiceImpl implements mypageService {

	@Autowired
	private mypageDao mypageDao;
	
	/**
	 * 마이페이지 
	 */
	@Override
	public Map<String, Object> passChk(HttpServletRequest request, memberVO memberVO) throws Exception {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		String result = "FAIL";
		String message = "";
		int count = 0;
		
		if(memberVO != null) {
			// 회원 정보 세션 값 확인
			if(request.getSession().getAttribute("sessMember") == null) {
				message = "로그인이 되어있지 않습니다. 로그인을 다시 진행해주세요.";
				
				resultMap.put("RESULT", result);
				resultMap.put("MESSAGE", message);
				
				return resultMap;
			}
			
			memberVO.setPass(cryptoUtil.sha256(memberVO.getPass()));
			
			count = mypageDao.passChk(memberVO);
			
			if(count > 0) {
				request.getSession().setAttribute("passCnt", count);
				
				result = "SUCCESS";
				message = "확인되었습니다.";
			} else {
				message = "비밀번호가 맞지 않습니다. 다시 입력해주세요.";
			}
		}
		
		resultMap.put("RESULT", result);
		resultMap.put("MESSAGE", message);
		
		return resultMap;
	}
}
