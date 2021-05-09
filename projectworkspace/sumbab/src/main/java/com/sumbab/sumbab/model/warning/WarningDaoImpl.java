package com.sumbab.sumbab.model.warning;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sumbab.sumbab.model.classify.ChangeClassifyDto;
import com.sumbab.sumbab.model.classify.MemberClassify;

@Repository
public class WarningDaoImpl implements WarningDao{
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public List<Warning> allReport() {
		return sqlSessionTemplate.selectList("allWarning");
	}

	@Override
	public Warning reportDetail(int warningNum) {
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
	public void insert(Warning warningDto) {
		sqlSessionTemplate.insert("insertWarning", warningDto);
	}

	@Override
	public List<MemberClassify> selectMember() {
		return sqlSessionTemplate.selectList("selectMember");
	}

	@Override
	public void updateMemberClassify(String id) {
		sqlSessionTemplate.update("returnClassify", id);
	}

	
}
