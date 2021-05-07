package com.sumbab.sumbab.model.storeview;

import java.util.List;
import java.util.Map;

import com.sumbab.sumbab.model.store.Store;

public interface StoreViewDao {


	public List<Store> selectAll();

	public Store selectOne(int storeNum);

	public List<Map<String, Object>> nearbyCafe(int storeNum);

	public List<Map<String, Object>> nearbyRestaurant(int storeNum);

	// ==================================================================================================================

	List<Map<String, Object>> selectReviews(int storeNum, int page_num);

	List<Map<String, Object>> selectReviewsPaging(int storeNum, int page_num);

	int getReviewCount(int storeNum);

	// ==================================================================================================================

	public List<Store> selectAllAddress();
	
	//=================================================
	//조회수 증가 얘는 살려두기
	public void upReadCount(int storeNum);

}