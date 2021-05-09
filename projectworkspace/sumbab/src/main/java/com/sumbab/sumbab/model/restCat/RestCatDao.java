package com.sumbab.sumbab.model.restCat;

public interface RestCatDao {

	public void insert(RestCat restCat);
	public void insertAfter(RestCat restCat);
	public int update(RestCat restCat);
	//store 삭제 시 cascade로 category row도 삭제되게 설계할 것
	
	public RestCat getRestCat(int storeNum);
	
}
