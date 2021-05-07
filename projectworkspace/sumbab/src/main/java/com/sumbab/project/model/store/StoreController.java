package com.sumbab.project.model.store;

import java.io.File;
import java.io.IOException;

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

import com.sumbab.project.model.cafeCat.CafeCatRegistReq;
import com.sumbab.project.model.cafeCat.CafeCatRegitService;
import com.sumbab.project.model.restCat.RestCatRegistReq;
import com.sumbab.project.model.restCat.RestCatRegitService;
import com.sumbab.project.model.review.ReviewService;
import com.sumbab.project.model.tag.TagService;

@Controller
@RequestMapping("/store/*")
@SessionAttributes("storeDTO")
public class StoreController {

	@RequestMapping(value = "/registerStep1", method = RequestMethod.GET)
	public String regitStore1(Model model) {
		model.addAttribute("storeDTO", new StoreVo());
		return "store/registerStep1";
	}

	@Autowired
	private StoreService storeService;

	@Autowired
	public void setStoreService(StoreService storeService) {
		this.storeService = storeService;
	}

	@RequestMapping(value = "/registerStep1-2", method = RequestMethod.POST)
	public String regitStore2(@ModelAttribute("storeDTO") StoreVo store, StoreRegisterRequest regReq, String fullAddress,
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

	@Autowired
	private TagService tagService;

	@Autowired
	public void setTagService(TagService tagService) {
		this.tagService = tagService;
	}

	// 테스트용 : 가게 상세보기 페이지 (from 정민님 github)
	@RequestMapping(value = "/StoreView/{storeNum}", method = RequestMethod.GET)
	public String detailView(@PathVariable int storeNum, Model model) {

		storeService.upReadCount(storeNum);
		model.addAttribute("storeVO", storeService.storeView(storeNum));
		model.addAttribute("countReview", reviewService.getReviewCount(storeNum));

		if (reviewService.getReviewCount(storeNum) != 0) {
			model.addAttribute("Reviewlist", reviewService.getList(storeNum));
			model.addAttribute("avgStar", reviewService.getAvgStar(storeNum));
			model.addAttribute("avgRevisit", reviewService.getAvgRevisit(storeNum));
			model.addAttribute("tagList", tagService.selectTagEachReview(storeNum));
			model.addAttribute("allTags", tagService.selectTagByStore(storeNum));

		} else if (reviewService.getReviewCount(storeNum) == 0) {
			model.addAttribute("avgStar", 0);
			model.addAttribute("avgRevisit", 0);
		}

		return "store/StoreView";
	}
}
