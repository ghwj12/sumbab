package com.sumbab.project.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.sumbab.project.model.StoreVo;
import com.sumbab.project.model.review.Review;
import com.sumbab.project.model.review.ReviewRegitReq;
import com.sumbab.project.model.review.ReviewService;
import com.sumbab.project.model.store.StoreService;
import com.sumbab.project.model.tag.TagService;

@Controller
public class ReviewController {
	
	@Autowired
	private StoreService storeService;
	@Autowired
	public void setStoreService(StoreService storeService) {
		this.storeService = storeService;
	}
	
	@RequestMapping(value="/review/writeReview/{storeNum}", method=RequestMethod.GET)
	public String writeReview(@PathVariable int storeNum, Model model, @ModelAttribute("storeVO")StoreVo store) {
		
		model.addAttribute("reviewDTO", new Review());
		model.addAttribute("storeVO", storeService.storeView(storeNum));//selectOne
		
		return "/review/writeReview";
	}
	
	@Autowired
	private ReviewService reviewService;
	@Autowired
	public void setReviewService(ReviewService reviewService) {
		this.reviewService = reviewService;
	}
	
	@Autowired
	private TagService tagService;
	@Autowired
	public void setTagService(TagService tagService) {
		this.tagService = tagService;
	}
	
	@RequestMapping(value="/review/completeWrReview", method=RequestMethod.POST)
	public String completeWriteReview(@ModelAttribute("reviewDTO")Review review, ReviewRegitReq reqR,
			@ModelAttribute("tag")ArrayList<String> tag, Model model, 
			@ModelAttribute("storeNum")int storeNum, HttpSession session, HttpServletRequest request,
			MultipartHttpServletRequest mtpReq) {
		
		//사진첨부 관련 method
		MultipartFile mf = mtpReq.getFile("attached");
		
		String path = "C:/02review/"; //파일 저장되는 실제 경로
		String originFileName = mf.getOriginalFilename();
		String picture = "";
		
		//파일 이름 겹치지 않게 등록한 시간을 string으로 입력
		if(originFileName == "") {
			picture = ""; // attached 없으면 파일등록 x
		}else {
			picture = System.currentTimeMillis() + originFileName;
			
			try {
				mf.transferTo(new File(path+picture));
			}catch (IllegalStateException e) {
				e.printStackTrace();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		reviewService.regit(reqR, session, storeNum, picture);
		
		
		for (int i = 0; i < tag.size(); i++) {
			tagService.regist(tag.get(i));
			tagService.insertReview_Tag(tag.get(i));
			tagService.insertStore_Tag(storeNum, tag.get(i));
		}
		
		return "/review/completeWrReview";
	}
	
	@RequestMapping(value="/review/myReviewList", method = RequestMethod.GET)
	public String myReviewList(Model model, HttpSession session) {
		
		String id = "deliciousman";
		session.setAttribute("id", session.getAttribute(id));
		model.addAttribute("reviewList", reviewService.getMyReviewList(id));
		model.addAttribute("storeList", reviewService.getStoreName(id));
		return "/review/myReviewList";
	}
	
	@RequestMapping(value="/review/reviewDetail/{reviewNum}", method = RequestMethod.GET)
	public String reviewDetail(Model model, @PathVariable int reviewNum) {
		
		model.addAttribute("reviewVO", reviewService.getReviewDetail(reviewNum));
		
		return "/review/reviewDetail";
	}
}
