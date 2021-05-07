package com.sumbab.sumbab.model.recommend;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sumbab.sumbab.model.store.Store;

@Repository
public class RecommendDaoImpl implements RecommendDao{
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public List<Store> selectRest(String category) {
		return sqlSessionTemplate.selectList("selectRest", category);
	}

	@Override
	public List<Store> selectCafe1(String category) {
		return sqlSessionTemplate.selectList("selectCafe1", category);
	}

	@Override
	public List<Store> selectCafe2(String category) {
		return sqlSessionTemplate.selectList("selectCafe2", category);
	}

}
