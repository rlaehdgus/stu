package com.indiv.front.member.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.indiv.front.vo.memberVO;

@Repository
public class memberDao {
	
	private static final String namespace = "front.mamberMapper";
	
	@Autowired
	private SqlSession sqlSession;

	/**
	 * 회원가입 Proc
	 * @param memberVO
	 */
	public void register(memberVO memberVO) {
		sqlSession.insert(namespace + ".register", memberVO);
	}

	/**
	 * 로그인 Proc
	 * @param memberVO
	 * @return
	 */
	public Map<String, Object> loginChk(memberVO memberVO) {
		return sqlSession.selectOne(namespace + ".userInfo", memberVO);
	}
}
