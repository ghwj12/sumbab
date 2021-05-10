package com.sumbab.sumbab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class MainController {
	//메인 페이지 이동
		@RequestMapping(value = "/", method = RequestMethod.GET)
		public String mainPageGET() {
		
			return "main";
			
		}
}
