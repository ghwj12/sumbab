package com.sumbab.sumbab.model.restCat;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RestCatDaoImpl implements RestCatDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Autowired
	public RestCatDaoImpl(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	@Override
	public void insert(RestCat restCat) {
		sqlSessionTemplate.insert("insertRestCat", restCat);
	}

	@Override
	public void insertAfter(RestCat restCat) {
		sqlSessionTemplate.insert("insertRestCat2", restCat);
	}
	
	@Override
	public int update(RestCat restCat) {
		return sqlSessionTemplate.update("updateRestCat", restCat);
	}

	@Override
	public RestCat getRestCat(int storeNum) {
		return sqlSessionTemplate.selectOne("getRestCat", storeNum);
	}


	

}
