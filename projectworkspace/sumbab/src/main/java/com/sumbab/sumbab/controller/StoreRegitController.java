package com.sumbab.sumbab.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.sumbab.sumbab.model.cafeCat.CafeCatRegistReq;
import com.sumbab.sumbab.model.cafeCat.CafeCatService;
import com.sumbab.sumbab.model.restCat.RestCatRegistReq;
import com.sumbab.sumbab.model.restCat.RestCatService;
import com.sumbab.sumbab.model.review.ReviewService;
import com.sumbab.sumbab.model.store.Store;
import com.sumbab.sumbab.model.store.StoreRegisterRequest;
import com.sumbab.sumbab.model.store.StoreService;
import com.sumbab.sumbab.model.storeview.StoreViewDao;
import com.sumbab.sumbab.model.tag.TagService;

@Controller
@RequestMapping("/store/*")
@SessionAttributes("storeDTO")
public class StoreRegitController {

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
	public String regitStore2(@ModelAttribute("storeDTO") Store store, StoreRegisterRequest regReq, String fullAddress,
			String extrAddress, MultipartHttpServletRequest mtpReq) {

		MultipartFile mf = mtpReq.getFile("attached");

		String path = "C:/01store/"; // 파일 저장되는 실제 경로
		String originFileName = mf.getOriginalFilename();
		String picture = "";

		if (originFileName == "") {
			picture = "";
		} else {
		picture = System.currentTimeMillis() + originFileName;
			try {
				mf.transferTo(new File(path + picture));
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		storeService.regist(regReq, fullAddress, extrAddress, picture);

		if (regReq.getClassify().equals("음식점")) {
			return "store/registerStep2_res";
		} else {
			return "store/registerStep2_cafe";
		}
	}

	@RequestMapping(value = "/registerStep1-2", method = RequestMethod.GET) // get으로 접근하면 regit1로 돌려보내기
	public String regitStore2() {
		return "redirect:/store/registerStep1";
	}

	@Autowired
	private RestCatService restCatService;
	@Autowired
	public void setRestCatService(RestCatService restCatService) {
		this.restCatService = restCatService;
	}
	@Autowired
	private CafeCatService cafeCatService;
	@Autowired
	public void setCafeCatService(CafeCatService cafeCatService) {
		this.cafeCatService = cafeCatService;
	}

	@RequestMapping(value = "/completeRegisterR", method = RequestMethod.POST) // 카테고리 작성 후 마지막 complete 페이지 요청
	public String regitComplete(RestCatRegistReq resCatRegitReq) {
		restCatService.resgist(resCatRegitReq);
		return "store/completeRegister";
	}

	@RequestMapping(value = "/completeRegisterC", method = RequestMethod.POST) // 카테고리 작성 후 마지막 complete 페이지 요청
	public String regitComplete(CafeCatRegistReq cafeCatRegitReq) {

		cafeCatService.resgist(cafeCatRegitReq);
		return "store/completeRegister";
	}
	
	@RequestMapping(value = "/regitStoreList", method = RequestMethod.GET)
	public String showMyRegitStoreList(Model model, HttpSession session) {
		String id = "deliciousman"; //세션에서 가져올 값
		
		session.setAttribute("id", session.getAttribute(id));
		model.addAttribute("myStoreList", storeService.getMyRegitStore(id));
		return "store/regitStoreList";
	}
	
	@Autowired
	private StoreViewDao storeInfoDao;
	@Autowired
	private ReviewService reviewService;
	@Autowired
	private TagService tagService;
	
	@RequestMapping(value="/storeDetail/{storeNum}", method = RequestMethod.GET)
	public String storeDetail(@PathVariable int storeNum, String classify, Model model) {
		
		classify = storeService.getClassify(storeNum);
		model.addAttribute("store", storeService.storeView(storeNum));
		
		if(classify.equals("음식점")) {
		model.addAttribute("restCatVO",restCatService.getRestCat(storeNum));
		}else {
			model.addAttribute("cafeCatVO",cafeCatService.getCafeCat(storeNum));
		}
		
		if (storeInfoDao.getReviewCount(storeNum) != 0) {
			model.addAttribute("avgStar", reviewService.getAvgStar(storeNum));
			model.addAttribute("avgRevisit", reviewService.getAvgRevisit(storeNum));
			model.addAttribute("tagList", tagService.selectTagEachReview(storeNum));
			model.addAttribute("allTags", tagService.selectTagByStore(storeNum));

		} else if (storeInfoDao.getReviewCount(storeNum) == 0) {
			model.addAttribute("avgStar", 0);
			model.addAttribute("avgRevisit", 0);
		}
		
		return "/store/storeDetail";
	}
	
	@RequestMapping(value="/deleteStoreProc/{storeNum}", method=RequestMethod.GET)
	public String deleteProc(@PathVariable int storeNum, Model model) {
		model.addAttribute("store", storeService.storeView(storeNum));
		return "/store/deleteStoreProc";
	}
	
	@RequestMapping(value="/deleteStoreProc/{storeNum}", method=RequestMethod.POST)
	public String deletedStore(@PathVariable int storeNum, String pwd, Model model) {
		Store store = storeService.storeView(storeNum);
		//cascade 속성 때문에 category는 자동 삭제된다.
		
		if(store.getPwd().equals(pwd)) {
			storeService.deleteStore(store);
			return "/store/deletedStore";
		}else {
			model.addAttribute("msg", "비밀번호가 일치하지 않습니다.");
			model.addAttribute("store", storeService.storeView(storeNum));
			return "/store/deleteStoreProc";
		}
	}

}
