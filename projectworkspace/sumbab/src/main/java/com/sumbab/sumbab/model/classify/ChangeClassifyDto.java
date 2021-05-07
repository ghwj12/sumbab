package com.sumbab.sumbab.model.classify;

import org.apache.ibatis.type.Alias;

@Alias("classifyDto")
public class ChangeClassifyDto {
	private String id;
	private int classify;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getClassify() {
		return classify;
	}
	public void setClassify(int classify) {
		this.classify = classify;
	}
	
	
}
