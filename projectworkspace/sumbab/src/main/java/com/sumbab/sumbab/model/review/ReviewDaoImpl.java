package com.sumbab.sumbab.model.review;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sumbab.sumbab.model.store.Store;


@Repository
public class ReviewDaoImpl implements ReviewDao {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Autowired
	public ReviewDaoImpl(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	@Override
	public void insert(Review review) {
		sqlSessionTemplate.insert("insertReview", review);
	}

	@Override
	public void update(Review review) {
		sqlSessionTemplate.update("updateReview", review);
	}

	@Override
	public void delete(int reviewNum) {
		sqlSessionTemplate.delete("deleteReview", reviewNum);
	}

	@Override //작성된 리뷰 수 가져오기
	public int getReviewCount(int storeNum) {
		return sqlSessionTemplate.selectOne("getReviewCount", storeNum);
	}
	
	@Override //리뷰 평균 별점 가져오기
	public float getAvgStar(int storeNum) {
		return 	sqlSessionTemplate.selectOne("getAvgStar", storeNum);
	}

	@Override
	public List<Review> getReviewList(int storeNum) {
		return sqlSessionTemplate.selectList("getReviewList",storeNum);
	}
	
	@Override
	public List<Review> getMyReviewList(String id) {
		return sqlSessionTemplate.selectList("getMyReviewList", id);
	}

	@Override
	public float getAvgRevisit(int storeNum) {
		return sqlSessionTemplate.selectOne("getAvgRevisit", storeNum);
	}
	//리뷰에서 사용되는 store list라서 review dao에 넣음
	@Override
	public List<Store> getStoreName(String id){
		return sqlSessionTemplate.selectList("getStoreNameforReview", id);
	}

	@Override
	public Review reviewDetail(int reviewNum) {
		return sqlSessionTemplate.selectOne("reviewDetail", reviewNum);
	}
}
