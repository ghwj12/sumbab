package com.sumbab.project.model;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class WarningDaoImpl implements WarningDao{
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public List<Warning> allReport() {
		return sqlSessionTemplate.selectList("allWarning");
	}

	@Override
	public WarningVo reportDetail(int warningNum) {
		return sqlSessionTemplate.selectOne("selectWarning", warningNum);
	}

	@Override
	public void changeClassify(ChangeClassifyDto classifyDto) {
		sqlSessionTemplate.update("changeClassify", classifyDto);
	}

	
}
