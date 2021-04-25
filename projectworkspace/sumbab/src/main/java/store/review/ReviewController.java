package store.review;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ReviewController {

	@RequestMapping(value="/review/writeReview", method=RequestMethod.GET)
	public String writeReview() {
		
		return "/review/writeReview";
	}
	
	@RequestMapping(value="/review/addPhoto", method=RequestMethod.GET)
	public String popupForAddPhoto() {
		
		return "/review/addPhoto";
	}
}
