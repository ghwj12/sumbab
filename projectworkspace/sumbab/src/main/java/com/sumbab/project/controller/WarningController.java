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
import com.sumbab.project.model.Notice;
import com.sumbab.project.model.WarningDto;
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
	public String reportDetail(Model model, @PathVariable int warningNum) {
		model.addAttribute("reportVo", warningService.reportDetail(warningNum));
		model.addAttribute("classifyDto", new ChangeClassifyDto());
		model.addAttribute("notice", new Notice());
		model.addAttribute("warningNum", warningNum);
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
	public String toNotice(Notice notice, Model model) {
		model.addAttribute("receiveNotice", notice);
		model.addAttribute("notice", new Notice());
		return "mypage/writeNotice";
	}
	
	@RequestMapping(value="/mypage/deleteWarningProcess/{warningNum}", method=RequestMethod.GET)
	public String deleteProcess(@PathVariable int warningNum, Model model) {
		model.addAttribute("warningNum", warningNum);
		return "mypage/deleteWarningProcess";
	}
	
	@RequestMapping(value="/mypage/deleteWarningProcess/{warningNum}", method=RequestMethod.POST)
	public String delete(@PathVariable int warningNum) {
		warningService.delete(warningNum);
		return "mypage/deleteWarning";
	}
	
	//여기서부터는 회원이 신고할 때 동작
	@RequestMapping("/storeWarning/mergeWarning")	//merge하면 컨트롤러 삭제
	public String mergeWarning() {
		return "storeWarning/mergeWarning";
	}
	
	@RequestMapping(value="/storeWarning/warningProcess", method=RequestMethod.GET)	//merge하면 {reviewNum} 추가
	public String warningProcess(Model model) {		
		int classify =	1; 							//session에 있는 classify 사용
		if(classify != 4) {
			model.addAttribute("warning", new WarningDto());
		}
		return "storeWarning/warningProcess";
	}
	
	@RequestMapping(value="/storeWarning/warningProcess", method=RequestMethod.POST)	//merge하면 {reviewNum} 추가
	public String insert(WarningDto warning) {		
		int reviewNum = 11;							//@PathVariable 사용
		String id = "suumbabR";						//session에 있는 id 사용
		warningService.insert(warning, reviewNum, id);
		return "storeWarning/warningAccept";
	}
	
}
