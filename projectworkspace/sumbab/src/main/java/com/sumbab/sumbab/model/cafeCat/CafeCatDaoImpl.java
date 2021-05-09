package com.sumbab.sumbab.model.cafeCat;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CafeCatDaoImpl implements CafeCatDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Autowired
	public CafeCatDaoImpl(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	@Override
	public void insert(CafeCat cafeCat) {
		sqlSessionTemplate.insert("insertCafeCat", cafeCat);
	}
	
	@Override
	public void insertAfter(CafeCat cafeCat) {
		sqlSessionTemplate.insert("insertCafeCat2", cafeCat);
	}

	@Override
	public int update(CafeCat cafeCat) {
		return sqlSessionTemplate.update("updateCafeCat", cafeCat);
	}

	@Override
	public CafeCat getCafeCat(int storeNum) {
		return sqlSessionTemplate.selectOne("getCafeCat", storeNum);
	}


}
