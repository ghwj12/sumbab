package store.review;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import store.Store;
import store.StoreService;
import store.review.tag.TagService;

@Controller
public class ReviewController {
	
	@Autowired
	private StoreService storeService;
	@Autowired
	public void setStoreService(StoreService storeService) {
		this.storeService = storeService;
	}
	
	@RequestMapping(value="/review/writeReview/{storeNum}", method=RequestMethod.GET)
	public String writeReview(@PathVariable int storeNum, Model model, @ModelAttribute("storeVO")Store store) {
		
		model.addAttribute("reviewDTO", new Review());
		model.addAttribute("storeVO", storeService.storeView(storeNum));//selectOne
		
		return "/review/writeReview";
	}
	
	//사진첨부 popup url
	@RequestMapping(value="/review/addPhoto", method=RequestMethod.GET)
	public String popupForAddPhoto() {
		
		return "/review/addPhoto";
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
	
	@RequestMapping(value="/review/completeWrReview", method=RequestMethod.POST)
	public String completeWriteReview(@ModelAttribute("reviewDTO")Review review, ReviewRegitReq reqR,
			@ModelAttribute("tag")ArrayList<String> tag, Model model, 
			@ModelAttribute("storeNum")int storeNum, HttpSession session) {
		
		reviewService.regit(reqR, session, storeNum);
		
		for (int i = 0; i < tag.size(); i++) {
			tagService.regist(tag.get(i));
			tagService.insertReview_Tag(tag.get(i));
			tagService.insertStore_Tag(storeNum, tag.get(i));
		}
		
		return "/review/completeWrReview";
	}
	
}
