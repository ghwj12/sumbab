package com.sumbab.sumbab.model.review;

import org.apache.ibatis.type.Alias;

@Alias("Review")
public class Review {

	private int reviewNum;
	private int storeNum;
	private String id;
	private String menu;
	private float star;
	private String content;
	private boolean revisit;
	private String regdate;
	private String picture;
	private Byte[] blobimg;
	
	//생성자 parameter로는 안쓰고 VO용으로 사용
	private String name; //store table과 join시, 값을 담을 field.
	
	public Review() {}

	public Review(int storeNum, String id, String menu, float star, String content,
				boolean revisit, String picture, Byte[] blobimg) {
		this.storeNum = storeNum;
		this.id = id;
		this.menu = menu;
		this.star = star;
		this.content = content;
		this.revisit = revisit;
		this.picture = picture;
		this.blobimg = blobimg;
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

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public Byte[] getBlobimg() {
		return blobimg;
	}

	public void setBlobimg(Byte[] blobimg) {
		this.blobimg = blobimg;
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}