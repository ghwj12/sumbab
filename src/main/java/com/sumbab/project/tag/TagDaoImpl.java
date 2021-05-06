package com.sumbab.project.tag;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TagDaoImpl implements TagDao {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Autowired
	public TagDaoImpl(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}


	@Override
	public List<Tag> selectTagByStore(int storeNum) {
		return sqlSessionTemplate.selectList("selectTagByStore", storeNum);
	}

	@Override
	public List<String> selectTagByReview(int reviewNum) {
		return sqlSessionTemplate.selectList("selectTagByReview", reviewNum);
	}
	
	@Override
	public List<Integer> selectReviewNumList(int storeNum) {
		return sqlSessionTemplate.selectList("selectReviewNumList", storeNum);
	}
	



}
