package com.sumbab.member.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.sumbab.member.domain.MemberVO;

public interface MemberDao {


	
	public void memberJoinMethod(MemberVO memberVO);
	
	public int idCheck(String id); 
}
