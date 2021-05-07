package com.sumbab.project.model.cafeCat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CafeCatRegitService {

	private CafeCatDaoImpl cafeCat;

	public CafeCatRegitService() {}
	
	@Autowired
	public CafeCatRegitService(CafeCatDaoImpl cafeCat) {
		this.cafeCat = cafeCat;
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
				
		cafeCat.insert(newCafeCat);
	}
}
