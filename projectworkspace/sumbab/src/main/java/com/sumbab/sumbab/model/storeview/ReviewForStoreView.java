package com.sumbab.sumbab.model.storeview;

import java.util.Date;

public class ReviewForStoreView {
	private String reviewNum;
	private String id;
	private String star;
	private Date regdate;
	private String content;
	private String picture;
	private String totalCount;

	public String getReviewNum() {
		return reviewNum;
	}

	public void setReviewNum(String reviewNum) {
		this.reviewNum = reviewNum;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStar() {
		return star;
	}

	public void setStar(String star) {
		this.star = star;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(String totalCount) {
		this.totalCount = totalCount;
	}

	@Override
	public String toString() {
		return "Review [reviewNum=" + reviewNum + ", id=" + id + ", star=" + star + ", regdate=" + regdate
				+ ", content=" + content + ", picture=" + picture + ", totalCount=" + totalCount + "]";
	}

}
