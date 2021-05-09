package com.sumbab.sumbab.model.login;


import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDaoImpl implements MemberDao {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	
	
	
//	public MemberDaoImpl(SqlSessionTemplate sqlSessionTemplate) {
//		
//		this.sqlSessionTemplate = sqlSessionTemplate;
//	}


	
	
	
	@Override
	public void insert(MemberVo vo) {
		sqlSessionTemplate.insert("insert", vo);
	
		
	}
	@Override
	public boolean select(MemberVo vo) {
		
		String result = sqlSessionTemplate.selectOne("mapper.login", vo);
		
		return (result == null) ? false : true ;
		
	}
	
	@Override
	public MemberVo select2(MemberVo vo) {
		MemberVo result = sqlSessionTemplate.selectOne("mapper.login2", vo);
		return result;
	}
	
	@Override
	public MemberVo idFind(MemberVo vo) {
	
		MemberVo result = sqlSessionTemplate.selectOne("mapper.idFind", vo);
		System.out.println(result + "1");
		return result ;
	}

	@Override
	public MemberVo pwdFind(MemberVo vo) {
		MemberVo result = sqlSessionTemplate.selectOne("mapper.pwdFind", vo);
	
		return result;
	}
	@Override
	public void kaLoginInsert(Map<String, Object> map) {
		sqlSessionTemplate.insert("mapper.kaLoginInsert", map);
		
	}
	@Override
	public boolean kaLoginSelect(Map<String, Object> map) {
		
		MemberVo result = sqlSessionTemplate.selectOne("mapper.kaLoginSelect", map);
		
		return (result == null) ? false : true ;	
	}
	@Override
	public MemberVo kaLoginSelect2(Map<String, Object> map) {
		
		MemberVo result = sqlSessionTemplate.selectOne("mapper.kaLoginSelect2", map);
		
		return result;
	}
	//정민
	@Override
	public void memberDelete(MemberVo memberVO) {
		sqlSessionTemplate.delete("memberDelete", memberVO);
		
	}
}
