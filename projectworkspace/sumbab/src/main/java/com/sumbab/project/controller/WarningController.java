package com.sumbab.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sumbab.project.model.ChangeClassifyDto;
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
	
	@RequestMapping(value="/mypage/reportDetail/{warningNum}", method=RequestMethod.GET)
	public String noticeDetail(Model model, @PathVariable int warningNum) {
		model.addAttribute("reportVo", warningService.reportDetail(warningNum));
		model.addAttribute("classifyDto", new ChangeClassifyDto());
		return "mypage/reportDetail";
	}
	
	@RequestMapping(value="/mypage/changeClassify", method=RequestMethod.POST)
	@ResponseBody
	public void changeClassify(@RequestBody ChangeClassifyDto classifyDto, Model model) {
		warningService.changeClassify(classifyDto);
	}
	
	@RequestMapping(value="/mypage/reportDetail/{warningNum}", method=RequestMethod.POST)
	public String toNotice(Model model, @PathVariable int warningNum) {
		model.addAttribute("reportVo", warningService.reportDetail(warningNum));
		model.addAttribute("classifyDto", new ChangeClassifyDto());
		return "mypage/writeNotice";
	}
	
}
