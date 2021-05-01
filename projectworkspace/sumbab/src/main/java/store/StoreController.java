package store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import store.cafeCat.CafeCatRegistReq;
import store.cafeCat.CafeCatRegitService;
import store.restCat.RestCatRegistReq;
import store.restCat.RestCatRegitService;
import store.review.ReviewService;

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
	private StoreService storeService;

	@Autowired
	public void setStoreService(StoreService storeService) {
		this.storeService = storeService;
	}

	@RequestMapping(value = "/registerStep1-2", method = RequestMethod.POST) 
	public String regitStore2(@ModelAttribute("storeDTO")Store store, 
			StoreRegisterRequest regReq, String fullAddress, String extrAddress) {
		
		storeService.regist(regReq, fullAddress, extrAddress);
		
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
	
	@Autowired
	private ReviewService reviewService;
	@Autowired
	public void setReviewService(ReviewService reviewService) {
		this.reviewService = reviewService;
	}
	
	//테스트용 : 가게 상세보기 페이지 (from 정민님 github)
	@RequestMapping(value="/StoreView/{storeNum}", method=RequestMethod.GET)
	public String detailView(@PathVariable int storeNum, Model model) {
		
		storeService.upReadCount(storeNum);
		model.addAttribute("storeVO", storeService.storeView(storeNum));
		model.addAttribute("countReview", reviewService.getReivewCount(storeNum));
		model.addAttribute("Reviewlist", storeService.get)
		
		return "store/StoreView";
	}
}
