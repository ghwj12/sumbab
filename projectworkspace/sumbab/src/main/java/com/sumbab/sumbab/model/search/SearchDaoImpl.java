package com.sumbab.sumbab.model.search;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sumbab.sumbab.model.store.Store;

@Repository
public class SearchDaoImpl implements SearchDao {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Autowired
	public SearchDaoImpl(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	@Override
	public List<Store> selectByKeyword(String input) {
		return sqlSessionTemplate.selectList("selectByKeyword", input);
	}

	@Override
	public List<Store> selectByTag(String inputT) {
		return sqlSessionTemplate.selectList("selectByTag", inputT);
	}
	
}
