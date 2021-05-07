package com.sumbab.project.model.search;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sumbab.project.model.store.StoreVo;

@Repository
public class SearchDaoImpl implements SearchDao {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Autowired
	public SearchDaoImpl(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	@Override
	public List<StoreVo> selectByKeyword(String input) {
		return sqlSessionTemplate.selectList("selectByKeyword", input);
	}

	@Override
	public List<StoreVo> selectByTag(String inputT) {
		return sqlSessionTemplate.selectList("selectByTag", inputT);
	}
	
}
