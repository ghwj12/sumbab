package com.sumbab.sumbab.model.classify;

import java.util.Date;

import org.apache.ibatis.type.Alias;


@Alias("memerClassify")
public class MemberClassify {

	private String id;
	private int classify;
	private Date regdate;
	
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
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
}
