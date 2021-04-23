package com.sumbab.project.model;

import java.util.List;

public interface NoticeDao {
	
	//어떤 회원인지 알기 위해 회원 구분 번호 가져오기
	public int selectClassify(String id);
	
	//해당하는 아이디의 공지글 불러오기
	public List<Notice> selectNotice(String id);
	
	//사이트 운영자일 경우 모든 공지글 불러오기
	public List<Notice> allNotice();
	
	//공지 상세보기
	public Notice noticeDetail(int noticeNum);
	
	//공지 올리기
	public void insert(Notice notice);
	
	//공지 수정
	public void update(Notice notice);
	
	//공지 삭제
	public void delete(int noticeNum);
	
	//해당 리뷰 가져오기
	public ReviewVo selectReview(int reviewNum);

}
