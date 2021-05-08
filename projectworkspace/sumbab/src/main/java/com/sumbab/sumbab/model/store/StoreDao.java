package com.sumbab.sumbab.model.store;

import java.util.List;

public interface StoreDao {

	public void insert(Store store);
	public void update(Store store);
	public void delete(Store store);
	
	public List<Store> myRegitStoreList(String id);
	public List<Store> selectByRestCat(String category);
	public List<Store> selectByCafeCat(String category);
	
	public Store selectOne(int storeNum); //가게 상세보기
	public void upReadCount(int storeNum);//가게 조회수 증가
	public String getClassify(int storeNum);
	
	//public List<Store> selectNearby(Store store); //현재위치값 들어있는 cords
	//public List<Store> selectByEditor(int editorNum); //editor table의 가게목록 seq 받아올 것
	
}
