package com.sumbab.sumbab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sumbab.sumbab.model.classify.ChangeClassifyDto;
import com.sumbab.sumbab.model.notice.Notice;
import com.sumbab.sumbab.model.warning.WarningDto;
import com.sumbab.sumbab.model.warning.WarningService;




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
	
	//�Ű�ó�� Ajax ���
	@ResponseBody
	@RequestMapping(value="/mypage/changeClassify", method=RequestMethod.POST)
	public int changeClassify(@RequestBody ChangeClassifyDto classifyDto, Model model) {
		warningService.changeClassify(classifyDto);
		return 1; //Ajax���� ��ȯ���� ������ success �κ��� �������� �����Ƿ� ���Ŀ��� �°� �ƹ��ų� return
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
	

	
	@RequestMapping(value="store/StoreView/Warning/warningProcess/{reviewNum}", method=RequestMethod.GET)
	public String warningProcess(Model model) {		
		int classify =	1; 							//session�� �ִ� classify ���
		if(classify != 4) {
			model.addAttribute("warning", new WarningDto());
		}
		return "Warning/warningProcess";
	}
	
	@RequestMapping(value="store/StoreView/Warning/warningProcess/{reviewNum}", method=RequestMethod.POST)
	public String insert(WarningDto warning) {		
		int reviewNum = 11;							//@PathVariable ���
		String id = "suumbabR";						//session�� �ִ� id ���
		warningService.insert(warning, reviewNum, id);
		return "Warning/warningAccept";
	}
	
	//���⼭���ʹ� ���� ���� ����
	@RequestMapping("/mypage/classifyAdmin")
	public String classifyAdmin(Model model) {
		model.addAttribute("memberList", warningService.selectMember());
		return "mypage/classifyAdmin";
	}
	
	@RequestMapping(value="/mypage/returnClassifyProcess/{id}/{classify}", method=RequestMethod.GET)
	public String returnClassifyProcess(@PathVariable String id, @PathVariable int classify, Model model) {
		model.addAttribute("id", id);
		model.addAttribute("classify", classify);
		return "mypage/returnClassifyProcess";
	}
	
	@RequestMapping(value="/mypage/returnClassifyProcess/{id}/{classify}", method=RequestMethod.POST)
	public String returnClassify(@PathVariable String id) {
		warningService.returnClassify(id);
		return "mypage/returnClassify";
	}
	
}