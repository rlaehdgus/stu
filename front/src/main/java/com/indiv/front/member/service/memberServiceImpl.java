package com.indiv.front.member.service;

import java.util.Map;

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
	 */
	@Override
	public void register(memberVO memberVO) throws Exception {
		
		// 입력 정보가 있을 경우
		if(memberVO != null) {
			// 비밀번호 암호화
			memberVO.setPass(cryptoUtil.sha256(memberVO.getPass()));
			
			memberDao.register(memberVO);
		}
	}

	/**
	 * 로그인 Proc
	 */
	@Override
	public Map<String, Object> loginChk(memberVO memberVO) throws Exception {
		Map<String, Object> map = null;
		
		// 입력 정보가 있을 경우
		if(memberVO != null) {
			// 비밀번호 암호화
			memberVO.setPass(cryptoUtil.sha256(memberVO.getPass()));
			
			map = memberDao.loginChk(memberVO);
		}
		
		return map;
	}

}
