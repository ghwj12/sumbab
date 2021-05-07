package com.sumbab.project.model.recommend;

import java.util.List;

import com.sumbab.project.model.store.Store;

public interface RecommendDao {

	//?��?��?�� 카테고리 추천
	public List<Store> selectRest(String category);
	
	//카페 카테고리 추천(?��?�� ?��간별 ?��?��)
	public List<Store> selectCafe1(String category);
	
	//카페 카테고리 추천(?��?�� ?��간별)
	public List<Store> selectCafe2(String category);
}
