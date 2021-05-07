package com.sumbab.sumbab.model.storeview;

import java.util.List;

import com.sumbab.sumbab.model.store.Store;

public interface StoreViewService {


	public List<Store> list();
	
	public Store readStore(int storeNum);
	
	public void upReadCount(int storeNum);
	

	


}
