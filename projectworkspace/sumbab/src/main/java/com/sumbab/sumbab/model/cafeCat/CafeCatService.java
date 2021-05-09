package com.sumbab.sumbab.model.cafeCat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CafeCatService {

	private CafeCatDaoImpl cafeCatDao;

	public CafeCatService() {}
	
	@Autowired
	public CafeCatService(CafeCatDaoImpl cafeCatDao) {
		this.cafeCatDao = cafeCatDao;
	}
	
	public void resgist(CafeCatRegistReq req) {
		
		CafeCat newCafeCat = new CafeCat(
				req.isSituation1(),
				req.isSituation2(),
				req.isSituation3(),
				req.isTimeslot(),
				req.isMood1(),
				req.isMood2(),
				req.isMood3(),
				req.isSize1(),
				req.isSize2(),
				req.isSize3());
				
		cafeCatDao.insert(newCafeCat);
	}
	
	public void insertAfter(CafeCat cafeCat) {
		cafeCatDao.insertAfter(cafeCat);
	}
	
	public CafeCat getCafeCat(int storeNum) {
		return cafeCatDao.getCafeCat(storeNum);
	}
	
	public int updateCafeCat(CafeCat cafeCat) {
		return cafeCatDao.update(cafeCat);
	}
}
