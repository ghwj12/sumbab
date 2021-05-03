package com.sumbab.project.model;

import java.util.List;

public interface RecommendDao {

	//음식점 카테고리 추천
	public List<StoreVo> selectRest(String category);
	
	//카페 카테고리 추천(영업 시간별 제외)
	public List<StoreVo> selectCafe1(String category);
	
	//카페 카테고리 추천(영업 시간별)
	public List<StoreVo> selectCafe2(String category1);
}
