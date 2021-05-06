package com.sumbab.project.model;

import java.util.Date;

import org.apache.ibatis.type.Alias;

@Alias("reviewVo")
public class ReviewVo {

	private String name;
	private String menu;
	private double star;
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
	public double getStar() {
		return star;
	}
	public void setStar(double star) {
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
	
	
}
