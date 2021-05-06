package com.sumbab.project.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sumbab.project.review.ReviewVo;
import com.sumbab.project.stroreview.StoreViewDao;
import com.sumbab.project.stroreview.StoreVo;
import com.sumbab.project.stroreviewservice.StoreViewService;
import com.sumbab.project.tag.TagService;

@Controller
public class StoreViewController {
	@Autowired
	private StoreViewService myStoreViewService;
	@Autowired
	private StoreViewDao myStoreDao;
	//==========================================================
	@Autowired
	private TagService tagService;

	public StoreViewController(StoreViewService myTestService, StoreViewDao mytestDao) {
		super();
		this.myStoreViewService = myTestService;
		this.myStoreDao = mytestDao;
	}

	// list jsp에서는 번호와 이름만꺼낼거임 테스트용도
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model) {
		List<StoreVo> list = myStoreViewService.list();
		System.out.println(list);
		model.addAttribute("list", list);
		return "list";
	}

	@RequestMapping(value = "/Store/StoreView/{store_num}", method = RequestMethod.GET)
	public String boardController(Model model, @PathVariable int store_num) {
		StoreVo storelist = myStoreViewService.readStore(store_num);
		List<Map<String, Object>> nbsCafe = myStoreDao.nearbyCafe(store_num);
		List<Map<String, Object>> nbsRestaurant = myStoreDao.nearbyRestaurant(store_num);
		// =======================================================================================
		int totalCount = myStoreDao.getReviewCount(store_num);
		model.addAttribute("storelist", storelist);
		model.addAttribute("nbsCafe", nbsCafe);
		model.addAttribute("nbsRestaurant", nbsRestaurant);
		// ==========================================================================
		List<Map<String, Object>> Reviewlist = myStoreDao.selectReviews(store_num, 1);
		model.addAttribute("Reviewlist", Reviewlist);
		System.out.println(Reviewlist);
		// ===========================================================================
		List<StoreVo> list = myStoreViewService.list();
		model.addAttribute("list", list);
		model.addAttribute("storeNum", store_num);
		model.addAttribute("totalCount", totalCount / 3 + 1); //
		System.out.println(list);
//=========================================================================================
		//5/5추가부분
		//해당게시물 조회수 증가
		myStoreDao.upReadCount(store_num);
		model.addAttribute("ReviewtotalCount", totalCount);
		if (myStoreDao.getReviewCount(store_num) != 0) {
			model.addAttribute("avgStar", myStoreDao.getAvgStar(store_num));
			model.addAttribute("avgRevisit", myStoreDao.getAvgRevisit(store_num));
			model.addAttribute("tagList", tagService.selectTagEachReview(store_num));
			model.addAttribute("allTags", tagService.selectTagByStore(store_num));

		} else if (myStoreDao.getReviewCount(store_num) == 0) {
			model.addAttribute("avgStar", 0);
			model.addAttribute("avgRevisit", 0);
		}

		return "Store/StoreView";
	}
//===========================================================================================================================

	@RequestMapping(value = "/Store/StoreView2/{store_num}/{page_num}", method = RequestMethod.GET)
	public @ResponseBody List<Map<String, String>> boardPaging(@PathVariable int store_num,
			@PathVariable int page_num) {

		List<Map<String, Object>> reviewList = myStoreDao.selectReviewsPaging(store_num, page_num);
		System.out.println(page_num + "입니다");
		int totalCount = myStoreDao.getReviewCount(store_num);

		System.out.println("totalCount = " + totalCount);
		System.out.println(reviewList);

		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		Map<String, String> map = null;
		ReviewVo vo = null;
		for (int i = 0; i < reviewList.size(); i++) {
			map = new HashMap<>();
			vo = (ReviewVo) reviewList.get(i);
			map.put("reviewNum", vo.getReviewNum());
			map.put("id", vo.getId());
			map.put("star", vo.getStar());
			map.put("content", vo.getContent());
			map.put("regdate", vo.getRegdate().toString());
			map.put("picture", vo.getPicture());
			list.add(map);
		}
		return list;
	}

//깔끔히 끝나면좋겠다...4/28
	// 완벽....5/5
	@RequestMapping(value = "/Gps/GPSlocation")
	public String GPSlocationController(Model model) {
		List<StoreVo> Addresslist = myStoreDao.selectAllAddress();
		System.out.println(Addresslist);
		model.addAttribute("GPS", Addresslist);
		return "Gps/GPSlocation";
	}
//================================================================================================================================
}
