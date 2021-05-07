package com.sumbab.sumbab.model.notice;

import java.util.Date;


//@Alias("notice")
public class Notice {

	private int noticeNum;
	private int reviewNum;
	private String title;
	private String content;
	private String authority;
	private String writer;
	private Date regdate;
	//?���? ?��?��?��?�� 공�? ?��리기�? ?��?���? ?�� ?��?��?�� �??��?��..(공�? ?��?���??��?�� 공�? ?��리기�? �? ?��?? ?���? ?��?��?��?�� �? ?��?�� 커맨?�� 객체�? ?��?��?���? ?���? ?��?��)
	private int classifyNum; //리뷰 번호�? ?���? �??�� ???�� ?��별하�? ?��?��
	private int reviewNumByRD; //RD:ReportDetail
	private String authorityByRD;
	
	public int getReviewNumByRD() {
		return reviewNumByRD;
	}

	public int getClassifyNum() {
		return classifyNum;
	}

	public void setClassifyNum(int classifyNum) {
		this.classifyNum = classifyNum;
	}

	public void setReviewNumByRD(int reviewNumByRD) {
		this.reviewNumByRD = reviewNumByRD;
	}

	public String getAuthorityByRD() {
		return authorityByRD;
	}

	public void setAuthorityByRD(String authorityByRD) {
		this.authorityByRD = authorityByRD;
	}

	public Notice() {}
	
	public Notice(int noticeNum, int reviewNum, String title, String content, String authority, String writer,
			Date regdate) {
		super();
		this.noticeNum = noticeNum;
		this.reviewNum = reviewNum;
		this.title = title;
		this.content = content;
		this.authority = authority;
		this.writer = writer;
		this.regdate = regdate;
	}
	
	public int getNoticeNum() {
		return noticeNum;
	}
	public void setNoticeNum(int noticeNum) {
		this.noticeNum = noticeNum;
	}
	public int getReviewNum() {
		return reviewNum;
	}
	public void setReviewNum(int reviewNum) {
		this.reviewNum = reviewNum;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
}
