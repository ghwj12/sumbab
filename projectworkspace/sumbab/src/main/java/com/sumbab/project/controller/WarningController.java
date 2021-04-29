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
	
	//신고처리 Ajax 사용
	@ResponseBody
	@RequestMapping(value="/mypage/changeClassify", method=RequestMethod.POST)
	public int changeClassify(@RequestBody ChangeClassifyDto classifyDto, Model model) {
		warningService.changeClassify(classifyDto);
		return 1; //Ajax에서 반환값이 없으면 success 부분이 동작하지 않으므로 형식에만 맞게 아무거나 return
	}
	
	@RequestMapping(value="/mypage/reportDetail/{warningNum}", method=RequestMethod.POST)
	public String toNotice(Model model, @PathVariable int warningNum) {
		model.addAttribute("reportVo", warningService.reportDetail(warningNum));
		model.addAttribute("classifyDto", new ChangeClassifyDto());
		return "mypage/writeNotice";
	}
	
}
