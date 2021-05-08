package com.sumbab.sumbab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MypageController {
	
	//마이페이지 맵핑이 없어서 만들었어요
	@RequestMapping(value="/mypage/mypageMain", method=RequestMethod.GET)
	public String goMypage() {
		
		return "/mypage/mypageMain";
	}
}
