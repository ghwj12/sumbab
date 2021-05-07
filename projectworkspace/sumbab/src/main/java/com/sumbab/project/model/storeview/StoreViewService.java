package com.sumbab.project.model.storeview;

import java.util.List;

import com.sumbab.project.model.store.Store;

public interface StoreViewService {


	public List<Store> list();
	
	public Store readStore(int storeNum);
	
	public void upReadCount(int storeNum);
	

	


}
