package com.sumbab.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sumbab.project.warning.WarningDto;
import com.sumbab.project.warningservice.WarningService;

@Controller
public class WarningController {
	@Autowired
	private WarningService warningService;
	
	
	//여기서부터 신고 컨트롤러
	@RequestMapping(value="Store/StoreView/Warning/warningProcess/{reviewNum}", method=RequestMethod.GET)	//merge하면 {reviewNum} 추가
	public String warningProcess(Model model, @PathVariable int reviewNum) {		
		System.out.println("신고1단계실행확인");
		int classify =	1; 							//session에 있는 classify 사용
		if(classify != 4) {
			model.addAttribute("warning", new WarningDto());
		}
		return "Warning/warningProcess";
	}

	@RequestMapping(value="Store/StoreView/Warning/warningProcess/{reviewNum}", method=RequestMethod.POST)	//merge하면 {reviewNum} 추가
	public String insert(WarningDto warning, @PathVariable int reviewNum) {		
		String id = "suumbabR";						//session에 있는 id 사용
		warningService.insert(warning, reviewNum, id);
		return "Warning/warningAccept";
	}
}