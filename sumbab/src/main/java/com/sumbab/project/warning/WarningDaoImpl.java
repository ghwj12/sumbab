package com.sumbab.project.warning;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class WarningDaoImpl implements WarningDao{
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public List<WarningVo> allReport() {
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

	@Override
	public void delete(int warningNum) {
		sqlSessionTemplate.delete("deleteWarning", warningNum);
	}

	@Override
	public void insert(WarningDto warningDto) {
		sqlSessionTemplate.insert("insertWarning", warningDto);
	}

	@Override
	public List<MemberClassifyVo> selectMember() {
		return sqlSessionTemplate.selectList("selectMember");
	}

	@Override
	public void updateMemberClassify(String id) {
		sqlSessionTemplate.update("returnClassify", id);
	}

	
}