package com.sumbab.project.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
	public String noticeDetail(HttpSession session, @PathVariable String classify) {
		session.setAttribute("reClassify", classify);
		return "recommendPage/mergeRecommend";
	}
	
	
}
