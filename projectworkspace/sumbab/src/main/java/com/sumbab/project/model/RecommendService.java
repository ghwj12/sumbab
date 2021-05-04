package com.sumbab.project.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecommendService {
	@Autowired
	private RecommendDaoImpl RecommendDao;
	
	public List<StoreVo> categoryRecommend(String classify, SelectedCategory selectedCategory) {
		if(classify.equals("음식점")) {
			String category = selectedCategory.getCategory1() + selectedCategory.getCategory2();
			System.out.println("category!!!!!!"+category);
			return RecommendDao.selectRest(category);
		}else {
			if(selectedCategory.getCategory1().equals("timeslot")) {
				String category = selectedCategory.getCategory1();
				if(selectedCategory.getCategory2().equals("0"))
					return RecommendDao.selectCafe2(category);
				else
					return RecommendDao.selectCafe1(category);
			}
			String category = selectedCategory.getCategory1() + selectedCategory.getCategory2();
			return RecommendDao.selectCafe1(category);
		}
	}
	
}
