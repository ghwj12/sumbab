package com.sumbab.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sumbab.project.model.WarningService;

@Controller
public class WarningController {
	
	@Autowired
	private WarningService warningService;

	@RequestMapping("/mypage/reportPage")
	public String reportPage(Model model) {
		model.addAttribute("reportList", warningService.bringWarning());
		return "mypage/reportPage";
	}
	
	@RequestMapping("/mypage/reportDetail/{warningNum}")
	public String noticeDetail(Model model, @PathVariable int warningNum) {
		model.addAttribute("reportVo", warningService.reportDetail(warningNum));
		return "mypage/reportDetail";
	}
	
	@RequestMapping(value="/mypage/changeClassify/{selectbox}", method=RequestMethod.GET)
	public String changeClassify(@PathVariable int selectbox, Model model) {
		model.addAttribute("classifyNum", selectbox);
		return "mypage/changeClassify";
	}
	
}