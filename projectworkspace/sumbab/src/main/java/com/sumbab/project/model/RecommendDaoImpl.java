package com.sumbab.project.model;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RecommendDaoImpl implements RecommendDao{
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public List<StoreVo> selectRest(String category) {
		return sqlSessionTemplate.selectList("selectRest", category);
	}

	@Override
	public List<StoreVo> selectCafe1(String category) {
		return sqlSessionTemplate.selectList("selectCafe1", category);
	}

	@Override
	public List<StoreVo> selectCafe2(String category1) {
		return sqlSessionTemplate.selectList("selectCafe2", category1);
	}

}
