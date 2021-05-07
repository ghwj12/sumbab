package com.sumbab.sumbab.model.storeview;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sumbab.sumbab.model.store.Store;


@Service
public class StoreViewServiceImpl implements StoreViewService {
	@Autowired
	private StoreViewDao myTestDao;

	public void setMyBoardDao(StoreViewDao myTestDao) {
		this.myTestDao = myTestDao;
	}

	public List<Store> list() {
		System.out.println("과욘?");
		return myTestDao.selectAll();
	}

	@Override
	public Store readStore(int storeNum) {
		return myTestDao.selectOne(storeNum);
	}

	@Override
	public void upReadCount(int storeNum) {
		myTestDao.upReadCount(storeNum);
		
	}



}
