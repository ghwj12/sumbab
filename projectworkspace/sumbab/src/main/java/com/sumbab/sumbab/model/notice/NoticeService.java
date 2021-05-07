package com.sumbab.sumbab.model.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sumbab.sumbab.model.review.Review;



@Service
public class NoticeService {
	@Autowired
	private NoticeDaoImpl noticeDao;
	private int classify;

	public int classify(String id) {
		classify = noticeDao.selectClassify(id);
		return classify;
	}
	
	public List<Notice> bringNotice(String id) {
		if(classify == 3) {
			return noticeDao.allNotice();
		} else {
			return noticeDao.selectNotice(id);
		}
	}
	
	public Notice noticeDetail(int noticeNum) {
		return noticeDao.noticeDetail(noticeNum);
	}
	
	public void write(Notice notice) {
		if(notice.getReviewNum() != 0)
			noticeDao.fromWarning(notice);	
		else
			noticeDao.insert(notice);
	}
	
	public void edit(Notice notice) {
		noticeDao.update(notice);
	}

	public void delete(int noticeNum) {
		noticeDao.delete(noticeNum);
	}
	
	public Review selectReview(int reviewNum) {
		return noticeDao.selectReview(reviewNum);
	}
	
}
