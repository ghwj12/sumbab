package com.sumbab.sumbab.model.review;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sumbab.sumbab.model.store.Store;



@Service
public class ReviewService {
	
	public ReviewService() {}
	private ReviewDao reviewDao;
	
	@Autowired
	public ReviewService(ReviewDao reviewDao) {
		this.reviewDao = reviewDao;
	}
	
	public void regit(ReviewRegitReq req, HttpSession session, int storeNum, String picture) {
		
		//세션 memberVO.id 값 임시 지정
		String id = "deliciousman";
		session.setAttribute("id", session.getAttribute(id));
		
		Review newReview = new Review(
				storeNum,
				id,
				req.getMenu(),
				req.getStar(),
				req.getContent(),
				req.isRevisit(),
				picture
				);
		System.out.println(newReview.getPicture());
		reviewDao.insert(newReview);
	}
	
	public void editReview(Review review) {
		reviewDao.update(review);
	}
	public void deleteReview(int reviewNum) {
		reviewDao.delete(reviewNum);
	}
	
	public int getReviewCount(int storeNum) {
		return reviewDao.getReviewCount(storeNum);
	}
	
	public List<Review> getList(int storeNum){
		return reviewDao.getReviewList(storeNum);
	}

	public float getAvgStar(int storeNum) {
		return reviewDao.getAvgStar(storeNum);
	}
	
	public float getAvgRevisit(int storeNum) {
		return reviewDao.getAvgRevisit(storeNum);
	}
	
	public List<Review> getMyReviewList(String id){
		return reviewDao.getMyReviewList(id);
	}
	
	public List<Store> getStoreName(String id){
		return reviewDao.getStoreName(id);
	}
	
	public Review getReviewDetail(int reviewNum) {
		return reviewDao.reviewDetail(reviewNum);
	}
}
