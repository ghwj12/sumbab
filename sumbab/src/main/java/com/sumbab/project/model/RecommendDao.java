package com.sumbab.project.model;

import java.util.List;

public interface RecommendDao {

	//?��?��?�� 카테고리 추천
	public List<StoreVo> selectRest(String category);
	
	//카페 카테고리 추천(?��?�� ?��간별 ?��?��)
	public List<StoreVo> selectCafe1(String category);
	
	//카페 카테고리 추천(?��?�� ?��간별)
	public List<StoreVo> selectCafe2(String category);
}
