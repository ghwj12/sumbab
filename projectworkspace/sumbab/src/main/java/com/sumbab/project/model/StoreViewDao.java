package com.sumbab.project.model;

import java.util.List;
import java.util.Map;

public interface StoreViewDao {


	public List<StoreVo> selectAll();

	public StoreVo selectOne(int storeNum);

	public List<Map<String, Object>> nearbyCafe(int storeNum);

	public List<Map<String, Object>> nearbyRestaurant(int storeNum);

	// ==================================================================================================================

	List<Map<String, Object>> selectReviews(int storeNum, int page_num);

	List<Map<String, Object>> selectReviewsPaging(int storeNum, int page_num);

	int getReviewCount(int storeNum);

	// ==================================================================================================================

	public List<StoreVo> selectAllAddress();
	
	//=================================================

	public void upReadCount(int storeNum);
	
	public float getAvgStar(int storeNum);
	
	public float getAvgRevisit(int storeNum);
}