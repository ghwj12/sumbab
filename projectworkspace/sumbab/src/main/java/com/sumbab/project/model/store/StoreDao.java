package com.sumbab.project.model.store;

import java.util.List;

public interface StoreDao {

	public void insert(StoreVo store);
	public void update(StoreVo store);
	public void delete(StoreVo store);
	
	public List<StoreVo> selectByRestCat(String category);
	public List<StoreVo> selectByCafeCat(String category);
	
	public StoreVo selectOne(int storeNum); //가게 상세보기
	public void upReadCount(int storeNum);//가게 조회수 증가
	
	//public List<Store> selectNearby(Store store); //현재위치값 들어있는 cords
	//public List<Store> selectByEditor(int editorNum); //editor table의 가게목록 seq 받아올 것
	
}
