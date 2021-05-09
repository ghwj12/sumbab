package com.sumbab.sumbab.model.cafeCat;

public interface CafeCatDao {

	public void insert(CafeCat cafeCat);
	public void insertAfter(CafeCat cafeCat);
	public int update(CafeCat cafeCat);
	//store 삭제 시 cascade로 category도 같이 삭제 되도록 설계할 것
	
	public CafeCat getCafeCat(int storeNum);
}
