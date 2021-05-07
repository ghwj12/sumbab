package com.sumbab.project.model.pick;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PickDaoImpl implements PickDao{

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public List<Integer> bringPick(String id) {
		return sqlSessionTemplate.selectList("bringPick", id);
	}

	@Override
	public void addPick(Pick pick) {
		sqlSessionTemplate.insert("addPick", pick);
	}

}
