package com.sumbab.member.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sumbab.member.dao.MemberDao;
import com.sumbab.member.domain.MemberVO;
import com.sumbab.member.service.MemberService;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

@Controller
public class MemberController {
	
	@Inject
	private MemberService memberService;
	
	public void setBoardService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@RequestMapping(value="/memberjoin", method=RequestMethod.GET)
	public String memberJoinPro() {
		return "memberjoin";
	}
	
	@RequestMapping(value="/memberjoin", method=RequestMethod.POST)
	public ModelAndView memberJoinPro(MemberVO memberVO) {
		ModelAndView mav = new ModelAndView();
		memberService.memberJoinProcess(memberVO);
		mav.setViewName("memberjoin");
		return mav;
	}
	
	
	
	
	@RequestMapping(value="/idCheck",method={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public String idCheck(HttpServletRequest request) {
		String id = request.getParameter("id");
		int result = memberService.idCheck(id);
		return Integer.toString(result);
	}
	
//	@RequestMapping(value="/memberjoin/idCheck")
//	public String idCheckFromView(
//			@RequestParam(value="id",defaultValue="",required=false )
//			String id,Model model) {
//		model.addAttribute("id",id);
//		return "memberjoin/idCheck";
//	}
//	
//	@RequestMapping(value="/memberjoin/idCheck",method=RequestMethod.POST)
//	public String idCheckAction(HttpServletRequest request,Model model,MemberVO memberVO) {
//		
//		MemberVO member = memberService.idCheck(id);
//		if(member==null) {
//			model.addAttribute("check",0);
//		}else {
//			model.addAttribute("check",1);
//		}
//		
//		model.addAttribute("id",id);
//		return "memberjoin/idCheck";
//		
//		
//	}
//	
	
	
	
	
	
}
