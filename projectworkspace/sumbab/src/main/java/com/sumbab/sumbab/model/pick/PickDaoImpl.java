package com.sumbab.sumbab.model.pick;

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

	
	@Override
	public Pick pickList(String id) {
		
		Pick result =  (Pick) sqlSessionTemplate.selectList("mapper.myPickSelect", id);
		
		return result;
	}
	
	@Override
	public int pickCount(int store_num) {
		
		
		int result = sqlSessionTemplate.update("mapper.myPickCount", store_num);
		return result;
		
	
	}@Override
	public StoreVo pickSelect(int store_num) {
		
		StoreVo result = sqlSessionTemplate.selectOne("mapper.myPickSelect", store_num);
		
		return result;
	}

	
	
	
}
