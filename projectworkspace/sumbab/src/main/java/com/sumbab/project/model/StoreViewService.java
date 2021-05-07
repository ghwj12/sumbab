package com.sumbab.project.model;

import java.util.List;

import com.sumbab.project.model.store.StoreVo;

public interface StoreViewService {


	public List<StoreVo> list();
	
	public StoreVo readStore(int storeNum);
	
	public void upReadCount(int storeNum);
	

	


}
