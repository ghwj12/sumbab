package com.sumbab.project.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecommendService {
	@Autowired
	private RecommendDaoImpl RecommendDao;
	
	public List<StoreVo> categoryRecommend(String classify, String category1, int category2) {
		if(classify.equals("음식점")) {
			String category = category1 + category2;
			return RecommendDao.selectRest(category);
		}else {
			if(category1.equals("timeslot")) {
				if(category2 == 0)
					return RecommendDao.selectCafe2(category1);
				else
					return RecommendDao.selectCafe1(category1);
			}
			String category = category1 + category2;
			return RecommendDao.selectCafe1(category);
		}
	}
	
}
