package com.sumbab.sumbab.model.tag;

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
	public void insert(Tag tag) {
		sqlSessionTemplate.insert("insertTag", tag);
	}

	@Override
	public void update(String tagName) {
		sqlSessionTemplate.update("upTagCount", tagName);
	}
	
	@Override
	public void delete(int reviewNum) {
		// TODO Auto-generated method stub
		//아직 어떻게 해야할지 모르겠음. review 수정할 때 모두 리셋 하면 tag count가 날아가기 때문에
		//리뷰수정-태그 수정할 때 review_tag에서만 삭제하는 걸로?
	}
	
	@Override
	public int check(String tagName) {
		return sqlSessionTemplate.selectOne("checkExistTag", tagName);
	}
	
	@Override
	public int getTagIDbyName(String tagName) {
		return sqlSessionTemplate.selectOne("getTagIDbyName", tagName);
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
	
	
	@Override
	public void insertReview_Tag() {
		sqlSessionTemplate.insert("insertReview_Tag");
	}

	@Override
	public void insertStore_Tag(int storeNum) {
		sqlSessionTemplate.insert("insertStore_Tag", storeNum);
	}
	
	@Override
	public void insertReview_Tags(int tagId) {
		sqlSessionTemplate.insert("insertReview_Tags", tagId);
	}
	
	@Override
	public void insertStore_Tags(Map<String, Integer> sequences) {
		sqlSessionTemplate.insert("insertStore_Tags", sequences);
	}


}
