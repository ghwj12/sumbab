package com.sumbab.project.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sumbab.project.model.RecommendService;

@Controller
public class RecommendController {

	@Autowired
	private RecommendService recommendService;

	//merge하면 삭제
	@RequestMapping("/recommendPage/mergeFirstPage")
	public String firstPage() {
		return "recommendPage/mergeFirstPage";
	}
	
	@RequestMapping("/recommendPage/mergeRecommend/{classify}")
	public String recommend(HttpSession session, @PathVariable String classify) {
		session.setAttribute("reClassify", classify);
		return "recommendPage/mergeRecommend";
	}
	
	//카테고리 선택 후 추천받을 때 Ajax 사용
	@ResponseBody
	@RequestMapping("/recommendPage/recommend/{classify}")
	public String categoryRecommend(Model model, @PathVariable String classify, @RequestParam("category1") String category1, @RequestParam("category2") int category2) {
		model.addAttribute("recommend", recommendService.categoryRecommend(classify, category1, category2));
		return "recommendPage/recommend";
	}
	
	
}
