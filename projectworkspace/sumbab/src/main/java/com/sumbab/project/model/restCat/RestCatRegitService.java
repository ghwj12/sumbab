package com.sumbab.project.model.restCat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestCatRegitService {

	private RestCatDaoImpl restCat;

	public RestCatRegitService() {}
	
	@Autowired
	public RestCatRegitService(RestCatDaoImpl restCat) {
		this.restCat = restCat;
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
				
		restCat.insert(newRestCat);
	}
}
