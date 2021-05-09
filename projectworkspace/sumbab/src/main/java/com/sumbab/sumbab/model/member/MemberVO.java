package com.sumbab.sumbab.model.member;



import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

@Alias(value = "Vo")
public class MemberVO {
	
	private String id;
	private String pwd;
    private String email;
	private String classify;
	private Timestamp date;

	public MemberVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public MemberVO(String id, String pwd, String email, String classify, Timestamp date) {
	
		this.id = id;
		this.pwd = pwd;
		this.email = email;
		this.classify = classify;
		this.date = date;
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getPwd() {
		return pwd;
	}



	public void setPwd(String pwd) {
		this.pwd = pwd;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getClassify() {
		return classify;
	}



	public void setClassify(String classify) {
		this.classify = classify;
	}



	public Timestamp getDate() {
		return date;
	}



	public void setDate(Timestamp date) {
		this.date = date;
	}



	

}
