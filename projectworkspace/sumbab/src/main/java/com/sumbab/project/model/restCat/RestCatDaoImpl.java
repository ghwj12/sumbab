package com.sumbab.project.model.restCat;

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
	public void update(RestCat restCat) {
		sqlSessionTemplate.update("updateRestCat", restCat);
	}

	

}
