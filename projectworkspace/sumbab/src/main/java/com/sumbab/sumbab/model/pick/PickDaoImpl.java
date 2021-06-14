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
	public List<JoinPickVo> joinPickList(String id) {
	
		return sqlSessionTemplate.selectList("pickDao.myPickSelect", id);
		
	}
	
	
	@Override
	public int pickCount(int store_num) {
		
		
		int result = sqlSessionTemplate.update("pickDao.myPickCount", store_num);
		
		
		return result;
		
	
	}@Override
	public StoreVo pickSelect(int store_num) {
		
		StoreVo result = sqlSessionTemplate.selectOne("pickDao.storeSelect", store_num);
		
		return result;
	}

	@Override
	public StoreVo StSelect(List result) {
		
		return (StoreVo) sqlSessionTemplate.selectList("pickDao.myPickSelect2", result);
	
	}
	
	@Override
	public void delPick(Pick vo) {
		sqlSessionTemplate.delete("pickDao.delPick", vo);
		
	}
	
}
