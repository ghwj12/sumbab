package store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import store.cafeCat.CafeCatRegistReq;
import store.cafeCat.CafeCatRegitService;
import store.restCat.RestCatRegistReq;
import store.restCat.RestCatRegitService;

@Controller
@RequestMapping("/store/*")
@SessionAttributes("storeDTO")
public class StoreController {

	@RequestMapping(value = "/registerStep1", method = RequestMethod.GET)
	public String regitStore1(Model model) {
		model.addAttribute("storeDTO", new Store());
		return "store/registerStep1";
	}
	@Autowired
	private StoreRegisterService storeRegisterService;

	@Autowired
	public void setStoreRegisterService(StoreRegisterService storeRegisterService) {
		this.storeRegisterService = storeRegisterService;
	}

	@RequestMapping(value = "/registerStep1-2", method = RequestMethod.POST) 
	public String regitStore2(@ModelAttribute("storeDTO")Store store, 
			StoreRegisterRequest regReq, String fullAddress, String extrAddress) {
		
		storeRegisterService.regist(regReq, fullAddress, extrAddress);
		
		if(regReq.getClassify().equals("음식점")) {
			return "store/registerStep2_res";
		}else {
			return "store/registerStep2_cafe";
		}
	}

	@RequestMapping(value = "/registerStep1-2", method = RequestMethod.GET) // get으로 접근하면 regit1로 돌려보내기
	public String regitStore2() {

		return "redirect:/store/registerStep1";
	}

	@Autowired
	private RestCatRegitService restCatRegitService;
	
	@Autowired
	public void setRestCatRegitService(RestCatRegitService restCatRegitService) {
		this.restCatRegitService = restCatRegitService;
	}
	@Autowired
	private CafeCatRegitService cafeCatRegitService;
	
	@Autowired
	public void setCafeCatRegitService(CafeCatRegitService cafeCatRegitService) {
		this.cafeCatRegitService = cafeCatRegitService;
	}
	@RequestMapping(value = "/completeRegisterR", method = RequestMethod.POST) // 카테고리 작성 후 마지막 complete 페이지 요청
	public String regitComplete(RestCatRegistReq resCatRegitReq) {
		restCatRegitService.resgist(resCatRegitReq);
		return "store/completeRegister";
	}
	@RequestMapping(value = "/completeRegisterC", method = RequestMethod.POST) // 카테고리 작성 후 마지막 complete 페이지 요청
	public String regitComplete(CafeCatRegistReq cafeCatRegitReq) {
		
		cafeCatRegitService.resgist(cafeCatRegitReq);
		return "store/completeRegister";
	}
}
