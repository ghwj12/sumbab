package com.sumbab.project.model.review;

import org.apache.ibatis.type.Alias;

@Alias("reviewVo")
public class Review {

	private int reviewNum;
	private int storeNum;
	private String id;
	private String menu;
	private float star;
	private String content;
	private boolean revisit;
	private String regDate;
	private String picture;
	
	public Review() {}

	public Review(int storeNum, String id, String menu, float star, String content, boolean revisit, String picture) {
		this.storeNum = storeNum;
		this.id = id;
		this.menu = menu;
		this.star = star;
		this.content = content;
		this.revisit = revisit;
		this.picture = picture;
	}

	public int getReviewNum() {
		return reviewNum;
	}

	public void setReviewNum(int reviewNum) {
		this.reviewNum = reviewNum;
	}

	public int getStoreNum() {
		return storeNum;
	}

	public void setStoreNum(int storeNum) {
		this.storeNum = storeNum;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}

	public float getStar() {
		return star;
	}

	public void setStar(float star) {
		this.star = star;
	}
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public boolean isRevisit() {
		return revisit;
	}

	public void setRevisit(boolean revisit) {
		this.revisit = revisit;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}
	
	
}
