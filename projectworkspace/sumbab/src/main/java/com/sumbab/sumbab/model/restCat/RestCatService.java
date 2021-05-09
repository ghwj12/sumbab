package com.sumbab.sumbab.model.restCat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestCatService {

	private RestCatDaoImpl restCatDao;

	public RestCatService() {}
	
	@Autowired
	public RestCatService(RestCatDaoImpl restCatDao) {
		this.restCatDao = restCatDao;
	}
	
	public void resgist(RestCatRegistReq req) {
		
		RestCat newRestCat = new RestCat(
				req.isSituation1(),
				req.isSituation2(),
				req.isSituation3(),
				req.isTimeslot1(),
				req.isTimeslot2(),
				req.isTimeslot3(),
				req.isTimeslot4(),
				req.isType1(),
				req.isType2(),
				req.isType3(),
				req.isType4());
				
		restCatDao.insert(newRestCat);
	}
	public void insertAfter(RestCat restCat) {
		restCatDao.insertAfter(restCat);
	}
	
	public RestCat getRestCat(int storeNum) {
		return restCatDao.getRestCat(storeNum);
	}
	
	public int updateRestCat(RestCat restCat) {
		return restCatDao.update(restCat);
	}
}
