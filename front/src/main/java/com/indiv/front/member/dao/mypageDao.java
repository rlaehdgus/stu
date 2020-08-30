package com.indiv.front.member.dao;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.indiv.front.vo.memberVO;

@Repository
public class mypageDao {

	private static final String namespace = "front.mypageMapper";
	
	@Autowired
	private SqlSession sqlSession;
	
	public int passChk(memberVO memberVO) {
		return sqlSession.selectOne(namespace + ".passChk", memberVO);
	}
}
