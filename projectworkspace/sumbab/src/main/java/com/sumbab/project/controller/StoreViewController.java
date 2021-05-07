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

import com.sumbab.project.model.ReviewVo;
import com.sumbab.project.model.StoreViewDao;
import com.sumbab.project.model.StoreViewService;
import com.sumbab.project.model.StoreVo;
import com.sumbab.project.model.tag.TagService;

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

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model) {
		List<StoreVo> list = myStoreViewService.list();
		System.out.println(list);
		model.addAttribute("list", list);
		return "list";
	}

	@RequestMapping(value = "/store/StoreView/{storeNum}", method = RequestMethod.GET)
	public String boardController(Model model, @PathVariable int storeNum) {
		StoreVo storelist = myStoreViewService.readStore(storeNum);
		List<Map<String, Object>> nbsCafe = myStoreDao.nearbyCafe(storeNum);
		List<Map<String, Object>> nbsRestaurant = myStoreDao.nearbyRestaurant(storeNum);
		// =======================================================================================
		int totalCount = myStoreDao.getReviewCount(storeNum);
		model.addAttribute("storelist", storelist);
		model.addAttribute("nbsCafe", nbsCafe);
		model.addAttribute("nbsRestaurant", nbsRestaurant);
		// ==========================================================================
		List<Map<String, Object>> Reviewlist = myStoreDao.selectReviews(storeNum, 1);
		model.addAttribute("Reviewlist", Reviewlist);
		System.out.println(Reviewlist);
		// ===========================================================================
		List<StoreVo> list = myStoreViewService.list();
		model.addAttribute("list", list);
		model.addAttribute("storeNum", storeNum);
		model.addAttribute("totalCount", totalCount / 3 + 1); //
		System.out.println(list);
//=========================================================================================

		myStoreDao.upReadCount(storeNum);
		model.addAttribute("ReviewtotalCount", totalCount);
		if (myStoreDao.getReviewCount(storeNum) != 0) {
			model.addAttribute("avgStar", myStoreDao.getAvgStar(storeNum));
			model.addAttribute("avgRevisit", myStoreDao.getAvgRevisit(storeNum));
			model.addAttribute("tagList", tagService.selectTagEachReview(storeNum));
			model.addAttribute("allTags", tagService.selectTagByStore(storeNum));

		} else if (myStoreDao.getReviewCount(storeNum) == 0) {
			model.addAttribute("avgStar", 0);
			model.addAttribute("avgRevisit", 0);
		}

		return "store/StoreView";
	}
//===========================================================================================================================

	@RequestMapping(value = "/store/StoreView2/{storeNum}/{page_num}", method = RequestMethod.GET)
	public @ResponseBody List<Map<String, String>> boardPaging(@PathVariable int storeNum,
			@PathVariable int page_num) {

		List<Map<String, Object>> reviewList = myStoreDao.selectReviewsPaging(storeNum, page_num);
		int totalCount = myStoreDao.getReviewCount(storeNum);

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


	@RequestMapping(value = "/Gps/GPSlocation")
	public String GPSlocationController(Model model) {
		List<StoreVo> Addresslist = myStoreDao.selectAllAddress();
		System.out.println(Addresslist);
		model.addAttribute("GPS", Addresslist);
		return "Gps/GPSlocation";
	}
//================================================================================================================================
}
