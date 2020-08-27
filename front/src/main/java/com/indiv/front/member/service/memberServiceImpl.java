package com.indiv.front.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indiv.front.member.dao.memberDao;
import com.indiv.front.vo.memberVO;

@Service
public class memberServiceImpl implements memberService {
	
	@Autowired
	private memberDao memberDao;

	/**
	 * 회원가입
	 */
	@Override
	public void register(memberVO memberVO) {
		
		// 입력 정보가 있을 경우
		if(memberVO != null) {
			memberDao.register(memberVO);
		}
	}

}
