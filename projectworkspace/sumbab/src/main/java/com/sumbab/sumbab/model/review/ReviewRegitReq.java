package com.sumbab.sumbab.model.review;

public class ReviewRegitReq {

	private String id;
	private String menu;
	private float star;
	private String content;
	private boolean revisit;
	private String picture;

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

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}
	
}
