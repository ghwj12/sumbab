package com.sumbab.project.model.review;

import java.util.List;

import org.apache.catalina.Store;

import com.sumbab.project.model.StoreVo;

public interface ReviewDao {

	public void insert(Review review);
	public void update(int reviewNum);
	public void delete(int reviewNum);
	
	public int getReviewCount(int storeNum);
	public float getAvgStar(int storeNum);
	public List<Review> getReviewList(int storeNum);
	public List<Review> getMyReviewList(String id);
	public List<StoreVo> getStoreName(String id);
	public float getAvgRevisit(int storeNum);
	public Review reviewDetail(int reviewNum);
	
}
