package com.sumbab.project.stroreviewservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sumbab.project.stroreview.StoreViewDao;
import com.sumbab.project.stroreview.StoreVo;

@Service
public class StoreViewServiceImpl implements StoreViewService {
	@Autowired
	private StoreViewDao myTestDao;
//서비스는 비교적한산한 편인듯싶다...
	public void setMyBoardDao(StoreViewDao myTestDao) {
		this.myTestDao = myTestDao;
	}

	public List<StoreVo> list() {
		System.out.println("과욘?");
		return myTestDao.selectAll();
	}

	@Override
	public StoreVo readStore(int store_num) {
		return myTestDao.selectOne(store_num);
	}

	@Override
	public void upReadCount(int store_num) {
		myTestDao.upReadCount(store_num);
		
	}



}
