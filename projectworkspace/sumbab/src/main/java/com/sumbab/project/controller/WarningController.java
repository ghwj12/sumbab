package com.sumbab.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sumbab.project.model.WarningReview;

//@Controller
public class WarningController {

	@RequestMapping("/{review_num}")
	public String warningStep1(/*리뷰 번호*/){
		return "신고 팝업창 뜨는 페이지";
	}
	
	@RequestMapping("/{review_num}")
	public String warningStep2(@ModelAttribute WarningReview warningRev) {
		return "신고 저장 후 페이지";
	}
}
