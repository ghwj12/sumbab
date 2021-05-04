package com.sumbab.project.model;

import org.apache.ibatis.type.Alias;

@Alias("selectedCategory")
public class SelectedCategory {

	private String category1;
	private String category2;
	
	public String getCategory1() {
		return category1;
	}
	public void setCategory1(String category1) {
		this.category1 = category1;
	}
	public String getCategory2() {
		return category2;
	}
	public void setCategory2(String category2) {
		this.category2 = category2;
	}
	
}
