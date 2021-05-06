package com.sumbab.project.model;

import java.util.Date;

import org.apache.ibatis.type.Alias;

@Alias("reviewVo")
public class ReviewVo {

	private String reviewNum;
	private String id;
	private String name;
	private String menu;
	private String star;
	private String content;
	private boolean revisit;
	private Date regdate;
	private String picture;
	
	public String getname() {
		return name;
	}
	public void setname(String name) {
		this.name = name;
	}
	public String getMenu() {
		return menu;
	}
	public void setMenu(String menu) {
		this.menu = menu;
	}
	public String getStar() {
		return star;
	}
	public void setStar(String star) {
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
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
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
	
	
}
