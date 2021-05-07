package com.sumbab.sumbab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sumbab.sumbab.model.category.SelectedCategory;
import com.sumbab.sumbab.model.recommend.RecommendService;

@Controller
public class RecommendController {

	@Autowired
	private RecommendService recommendService;

	//merge하면 삭제
	@RequestMapping("/recommendPage/mergeFirstPage")
	public String firstPage() {
		return "recommendPage/mergeFirstPage";
	}
	
	//merge하면 경로 수정
	@RequestMapping("/recommendPage/mergeRecommend/{classify}")
	public String recommend(Model model, @PathVariable String classify) {
		model.addAttribute("reClassify", classify);
		model.addAttribute("selectedCategory", new SelectedCategory());
		return "recommendPage/mergeRecommend";
	}
	
	//카테고리 추천 
	@RequestMapping(value="/recommendPage/recommend/{classify}", method=RequestMethod.POST)
	public String categoryRecommend(Model model, @PathVariable String classify, SelectedCategory selectedCategory) {
		model.addAttribute("recommendList", recommendService.categoryRecommend(classify, selectedCategory));
		return "recommendPage/recommend";
	}
	
	
}
