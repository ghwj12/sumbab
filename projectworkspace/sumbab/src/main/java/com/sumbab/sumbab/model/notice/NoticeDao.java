package com.sumbab.sumbab.model.notice;

import java.util.List;

import com.sumbab.sumbab.model.review.Review;



public interface NoticeDao {
	
	//?��?�� ?��?��?���? ?���? ?��?�� ?��?�� 구분 번호 �??��?���?
	public int selectClassify(String id);
	
	//?��?��?��?�� ?��?��?��?�� 공�?�? 불러?���?
	public List<Notice> selectNotice(String id);
	
	//?��?��?�� ?��?��?��?�� 경우 모든 공�?�? 불러?���?
	public List<Notice> allNotice();
	
	//공�? ?��?��보기
	public Notice noticeDetail(int noticeNum);
	
	//공�? ?��리기
	public void insert(Notice notice);
	
	//?���? ?��?��?��?�� 리뷰 번호 받아?�� 공�? ?��리기
	public void fromWarning(Notice notice);
	
	//공�? ?��?��
	public void update(Notice notice);
	
	//공�? ?��?��
	public void delete(int noticeNum);
	
	//?��?�� 리뷰 �??��?���?
	public Review selectReview(int reviewNum);

}
