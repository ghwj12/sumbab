package com.sumbab.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sumbab.project.review.ReviewVo;
import com.sumbab.project.stroreview.StoreVo;
import com.sumbab.project.stroreviewservice.StoreViewService;

@Controller
public class ReviewController {
	
	@Autowired
	private StoreViewService storeViewService;

	
	
	
	@RequestMapping(value="/review/writeReview/{store_num}", method=RequestMethod.GET)
	public String writeReview(@PathVariable int store_num, Model model, @ModelAttribute("storelist")StoreVo store) {
		
		model.addAttribute("reviewDTO", new ReviewVo());
		model.addAttribute("storelist", storeViewService.readStore(store_num));//selectOne
		
		return "/review/writeReview";
	}

}
