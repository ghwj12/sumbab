package com.sumbab.project.model;

import java.util.List;

public interface StoreViewService {


	public List<StoreVo> list();
	
	public StoreVo readStore(int storeNum);
	
	public void upReadCount(int storeNum);
	

	


}
