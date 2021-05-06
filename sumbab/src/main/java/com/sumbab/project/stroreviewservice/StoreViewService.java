package com.sumbab.project.stroreviewservice;

import java.util.List;

import com.sumbab.project.stroreview.StoreVo;

public interface StoreViewService {

	//전체조회 글과 이름만
	public List<StoreVo> list();
	
	public StoreVo readStore(int store_num);
	
	public void upReadCount(int storeNum);
	

	


}
