package login;

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

import com.fasterxml.jackson.databind.JsonNode;

@Controller
public class SbController {
	
	@Autowired
	private MemberService memberService;
	
	
//	public void setMemberService(MemberService memberService) {
//		this.memberService = memberService;
//	}


	
	
	
	//로그인 페이지
	@RequestMapping(value = "/sb/login", method = RequestMethod.GET)
	public String loginGet(@ModelAttribute("memberVo") MemberVo vo, Model model, HttpSession session) {
		
		String kakaoUrl = KakaoController.getAuthorizationUrl(session);
		model.addAttribute("kakao_url", kakaoUrl);
		
		return "/sb/login";
	}
	//로그인 요청 처리 `
	@RequestMapping(value = "/sb/login", method = RequestMethod.POST)
	public String login(@ModelAttribute("memberVo") MemberVo vo,
			Model model,
			HttpSession session,
			HttpServletResponse response) {
		
		boolean result = memberService.login(vo, session);
	
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
			
			return "/sb/main";
		
		}else {
			
		
		
		return "redirect:/sb/login";
		}
	}

	//로그아웃 요청 
	@RequestMapping(value="/sb/logout",method = RequestMethod.GET)
	public String logout(MemberVo memberVo, HttpSession session) {
		
		MemberVo vo = (MemberVo) session.getAttribute("vo");
		if(vo != null) {
			memberService.logout(session);
			
			return "/sb/logout";
		}
		
		return "/sb/logout";
		
	}

	
	
	//계정 찾기 폼 요청 
		@RequestMapping(value="/sb/memberFind", method=RequestMethod.GET)
		public String memberFindGet(@ModelAttribute("memberVo") MemberVo vo) {
			return "/sb/memberFind";
		}
	
		
	//아이디 찾기 요청
	@RequestMapping(value="/sb/idFindResult", method=RequestMethod.POST)
	public String idFindPost(@ModelAttribute("memberVo") MemberVo vo, Model model) {
		
		 MemberVo result = memberService.idFind(vo);
		
		
		 if(result != null) {
			String id = result.getId();
			model.addAttribute("idFind", id);
			
			return "/sb/idFindResult";
		
		 }else {
			
				
			return "redirect:/sb/memberFind";
		 }
	
			
		 
	}
	//비번찾기 요청
	@RequestMapping(value="/sb/pwdFindResult",method=RequestMethod.POST)
	public String pwdFindPost(@ModelAttribute("memberVo") MemberVo vo, Model model) {
		
		MemberVo result = memberService.pwdFind(vo);
	
		if(result != null) {
			String pwd = result.getPwd();
			model.addAttribute("pwdFind", pwd);
		
			return "/sb/pwdFindResult";
			
		}else {
			
			
			return "redirect:/sb/memberFind";
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
		

		mav.setViewName("/sb/main"); 
		
		
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("kemail", session.getAttribute("kemail"));
		map.put("kname", session.getAttribute("kname"));
		boolean result = memberService.kaLoginSelect(map);
		
		//값이 있다 true
		if(result) {
			
		
			//db값 세션으로 생성("Vo")
			memberService.kaLoginSelect2(map, session);
			
		//값이 없다 false	
		}else {
			
			memberService.kaLoginInsert(map);
			memberService.kaLoginSelect2(map, session);
		
		}
		
		
		
		return mav;
	// end kakaoLogin()
	
	}catch (Exception e) {
		
		ModelAndView mav = new ModelAndView();
		
		String kakaoUrl = KakaoController.getAuthorizationUrl(session);
		mav.addObject("kakao_url", kakaoUrl);
		
		//새로고침시 메인 페이지로 바꾸기???
		mav.setViewName("/sb/login"); 
		return mav;
	}
		
	}

	
	//로그아웃 요청 
		@RequestMapping(value="/sb/kalogout",method = RequestMethod.GET)
		public String kalogout(HttpSession session, Model model) throws Exception {
			
			
			
		
		
			
			String aT = (String) session.getAttribute("access_Token");
			
			if(aT != null) {
				
				
	            
				

				memberService.kalogout(session);
				
			
				return "/sb/kalogout";
			}
			
			return "/sb/kalogout";
			
		}



	


}









	
	

