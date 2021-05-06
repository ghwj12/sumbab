package com.sumbab.project.stroreview;


import java.util.List;
import java.util.Map;

public interface StoreViewDao {

	// 테스트 첫페이지에 사용 전체 게시물 출력 번호와 이름만
	public List<StoreVo> selectAll();

	public StoreVo selectOne(int store_num);

	public List<Map<String, Object>> nearbyCafe(int store_num);

	public List<Map<String, Object>> nearbyRestaurant(int store_num);

	// ==================================================================================================================
	// 리뷰 테이블에서 가져올것들
	List<Map<String, Object>> selectReviews(int store_num, int page_num);

	List<Map<String, Object>> selectReviewsPaging(int store_num, int page_num);

	int getReviewCount(int storeNum);

	// ==================================================================================================================
	// 지역추천및 위치기반을 위한
	public List<StoreVo> selectAllAddress();
	
	//=================================================
	//조회수 증가
	public void upReadCount(int store_num);
	
	public float getAvgStar(int store_num);
	
	public float getAvgRevisit(int store_num);
}