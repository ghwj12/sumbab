package com.sumbab.sumbab.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.databind.JsonNode;
import com.sumbab.sumbab.model.login.LoginService;
import com.sumbab.sumbab.model.login.MemberVo;

@Controller
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	
//	public void setMemberService(MemberService memberService) {
//		this.memberService = memberService;
//	}


	
	
	
	//로그인 페이지
	@RequestMapping(value = "/sb/login", method = RequestMethod.GET)
	public String loginGet(@ModelAttribute("memberVo") MemberVo vo, Model model, HttpSession session) {
		
		String kakaoUrl = KakaoController.getAuthorizationUrl(session);
		model.addAttribute("kakao_url", kakaoUrl);
		
		return "/login/login";
	}
	//로그인 요청 처리 `
	@RequestMapping(value = "/sb/login", method = RequestMethod.POST)
	public String login(@ModelAttribute("memberVo") MemberVo vo,
			Model model,
			HttpSession session,
			HttpServletResponse response) {
		
		boolean result = loginService.login(vo, session);
	
		if(result == true) {
			
			
		
			session.getAttribute("vo");
			
//			Map<String, Object> map = new HashMap<String, Object>();
//			map.put("id", mVo.getId());
//			map.put("pwd", mVo.getPwd());
//			map.put("email", mVo.getEmail());
//			
//			
//		
//			model.addAttribute("vo", map);
		
			
//			
//			String sId = session.getId();
//			Cookie cookies = new Cookie("loginCookie", sId);
//			cookies.setPath("/");
//			int amount = 60 * 10 * 6;
//			cookies.setMaxAge(amount);
//			response.addCookie(cookies);
//			
			
			return "/login/main";
		
		}else {
			
		
		
		return "redirect:/login/login";
		}
	}

	//로그아웃 요청 
	@RequestMapping(value="/sb/logout",method = RequestMethod.GET)
	public String logout(MemberVo memberVo, HttpSession session) {
		
		MemberVo vo = (MemberVo) session.getAttribute("vo");
		if(vo != null) {
			loginService.logout(session);
			
			return "/login/logout";
		}
		
		return "/login/logout";
		
	}

	
	
	//계정 찾기 폼 요청 
		@RequestMapping(value="/sb/memberFind", method=RequestMethod.GET)
		public String memberFindGet(@ModelAttribute("memberVo") MemberVo vo) {
			return "/login/memberFind";
		}
	
		
	//아이디 찾기 요청
	@RequestMapping(value="/sb/idFindResult", method=RequestMethod.POST)
	public String idFindPost(@ModelAttribute("memberVo") MemberVo vo, Model model) {
		
		 MemberVo result = loginService.idFind(vo);
		
		
		 if(result != null) {
			String id = result.getId();
			model.addAttribute("idFind", id);
			
			return "/login/idFindResult";
		
		 }else {
			
				
			return "redirect:/login/memberFind";
		 }
	
			
		 
	}
	//비번찾기 요청
	@RequestMapping(value="/sb/pwdFindResult",method=RequestMethod.POST)
	public String pwdFindPost(@ModelAttribute("memberVo") MemberVo vo, Model model) {
		
		MemberVo result = loginService.pwdFind(vo);
	
		if(result != null) {
			String pwd = result.getPwd();
			model.addAttribute("pwdFind", pwd);
		
			return "/login/pwdFindResult";
			
		}else {
			
			
			return "redirect:/login/memberFind";
		}
		
		
		
		
	}
	
	
	
	
	
	




	
	//카카오 로그인(사용자 정보 가져와서 뷰로 넘기)
	@RequestMapping(value = "/sb/main", produces = "application/json", method = RequestMethod.GET)
	public ModelAndView kakaoLogin(@RequestParam("code") String code,
			@ModelAttribute("memberVo") MemberVo vo,
			HttpServletRequest request,
			HttpServletResponse response,
			HttpSession session) throws Exception { 
		try {
		ModelAndView mav = new ModelAndView();

		//로그아웃 url 전달
		String kLU = KakaoController.getLogoutUrl(session);
		mav.addObject("kLogoutUrl", kLU);
		
			
		
		// 결과값을 node에 담아줌
		JsonNode node = KakaoController.getAccessToken(code);
		session.setAttribute("access_Token", node);
		System.out.println("node" + node);
		// accessToken에 사용자의 로그인한 모든 정보가 들어있음
		JsonNode accessToken = node.get("access_token");
		
		String at = accessToken.toString();
		System.out.println("at:" + at);
		session.setAttribute("access_Token", at);
		
		// 사용자의 정보
		JsonNode userInfo = KakaoController.getKakaoUserInfo(accessToken);
		
		
		String kemail;
		String kname;

		
		JsonNode properties = userInfo.path("properties");
		JsonNode kakao_account = userInfo.path("kakao_account");
		System.out.println(properties);
		
		
		kemail = kakao_account.path("email").asText();
		System.out.println("1" + kemail);
		kname = properties.path("nickname").asText();

		
		session.setAttribute("kemail", kemail);
		session.setAttribute("kname", kname); 
		

		mav.setViewName("/login/main"); 
		
		
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("kemail", session.getAttribute("kemail"));
		map.put("kname", session.getAttribute("kname"));
		boolean result = loginService.kaLoginSelect(map);
		
		//값이 있다 true
		if(result) {
			
		
			//db값 세션으로 생성("Vo")
			loginService.kaLoginSelect2(map, session);
			
		//값이 없다 false	
		}else {
			
			loginService.kaLoginInsert(map);
			loginService.kaLoginSelect2(map, session);
		
		}
		
		
		
		return mav;
	// end kakaoLogin()
	
	}catch (Exception e) {
		
		ModelAndView mav = new ModelAndView();
		
		String kakaoUrl = KakaoController.getAuthorizationUrl(session);
		mav.addObject("kakao_url", kakaoUrl);
		
		//새로고침시 메인 페이지로 바꾸기???
		mav.setViewName("/login/login"); 
		return mav;
	}
		
	}

	
	//로그아웃 요청 
		@RequestMapping(value="/sb/kalogout",method = RequestMethod.GET)
		public String kalogout(HttpSession session, Model model) throws Exception {
			
			
			
		
		
			
			String aT = (String) session.getAttribute("access_Token");
			
			if(aT != null) {
				
				
	            
				

				loginService.kalogout(session);
				
			
				return "/login/kalogout";
			}
			
			return "/login/kalogout";
			
		}



		//회원탈퇴 get 정민
		@RequestMapping(value = "/memberDeleteView", method = RequestMethod.GET)
		public String memberDeleteView(HttpSession session) {
			

			return "member/memberDeleteView";
		}
		 //정민
		@RequestMapping(value = "/memberDelete", method = RequestMethod.POST)
		public String memberDeleteView(MemberVo memberVO, HttpSession session, RedirectAttributes rttr) {
			
			MemberVo member = (MemberVo) session.getAttribute("vo");
			
			String sessionPwd = member.getPwd();
			
			String voPwd = memberVO.getPwd();
			
			System.out.println(sessionPwd+ "세션연결이 되었군...");
			System.out.println(voPwd + "근데 외그럴까나..");
			System.out.println(member);
			
			if(!(sessionPwd.equals(voPwd))) {
				rttr.addFlashAttribute("msg", false);
				return "redirect:/membmer/memberDeleteView";
			}
			loginService.memberDelete(memberVO);
			session.invalidate();
			return "list";
		}

		

}









	
	
