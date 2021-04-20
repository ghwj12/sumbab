package com.sumbab.project.model;

import org.mybatis.spring.SqlSessionTemplate;

public class MemberDaoImpl implements MemberDao{
	
	private SqlSessionTemplate sqlSessionTemplate;
	
	public MemberDaoImpl(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	@Override
	public int selectCalssify(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Notice selectNotice(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Notice allNotice() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
