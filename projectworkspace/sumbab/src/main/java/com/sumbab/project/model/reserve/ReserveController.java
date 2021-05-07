package com.sumbab.project.model.reserve;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("reserveDTO")
public class ReserveController {
	
	@Autowired
	private ReserveService reserveService;
	
	@Autowired
	public void setReserveService(ReserveService reserveService) {
		this.reserveService = reserveService;
	}

	//마이페이지-->나의 예약한 음식점 리스트 보기:리스트 출력
	@RequestMapping(value="/reserve/reserveList", method=RequestMethod.GET)
	public String reserveList(Model model, HttpSession session) {
		
		String memberID="deliciousman";
		session.getAttribute(memberID);
		
		model.addAttribute("listFuture", reserveService.getListF(memberID));
		model.addAttribute("listPast", reserveService.getListP(memberID));
		model.addAttribute("storeName", reserveService.getStoreName(memberID));
		
		return "reserve/reserveList";
	}
	
	//식당 상세보기-->예약하기 요청
	@RequestMapping(value="/reserve/reserveForm/{storeNum}", method=RequestMethod.GET)
	public String reserve(@PathVariable int storeNum, Model model) {
		
		model.addAttribute("reserveDTO", new Reserve());
		return "reserve/reserveForm";
	}
	
	@RequestMapping(value="/reserve/completeReserve", method=RequestMethod.POST)
	public String alignValue(@ModelAttribute("reserveDTO")Reserve reserve, ReserveRegitReq resReq, 
			String datepicker, String timepicker, Model model, HttpSession session, @ModelAttribute("storeNum")int storeNum) {
		
		reserveService.regit(resReq, datepicker, timepicker, session, storeNum);
		return "reserve/completeReserve";
	}
	

	//예약(미래) 삭제하기---요청
	@RequestMapping(value="/reserve/cancelReserve/{reserveSeq}", method=RequestMethod.GET)
	public String cancelProcess(@PathVariable int reserveSeq, @ModelAttribute String memberID, Model model) {
		model.addAttribute("reserveSeq", reserveSeq);
		model.addAttribute("memberID", memberID);
		
		return "reserve/cancelReserve";
	}
	
	//예약(미래) 삭제하기---실행
	@RequestMapping(value="/reserve/cancelReserve/{reserveSeq}", method=RequestMethod.POST)
	public String completeCancel(@PathVariable int reserveSeq) {
		reserveService.delete(reserveSeq);
		
		return "reserve/completeCancel";
	}

}
