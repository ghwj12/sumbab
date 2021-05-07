package com.sumbab.member.dao;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.sumbab.member.domain.MemberVO;

@Repository
public class MemberDaoMybatis implements MemberDao {

	@Inject
	private SqlSessionTemplate sqlSessionTemplate;
		
	@Override
	public void memberJoinMethod(MemberVO memberVO) {
		sqlSessionTemplate.insert("member.join",memberVO);
	}
	
	@Override
	public int idCheck(String id) {
		
		int result = sqlSessionTemplate.selectOne("member.idCheck",id);
		
		return result;

	}
	

	
	
}
