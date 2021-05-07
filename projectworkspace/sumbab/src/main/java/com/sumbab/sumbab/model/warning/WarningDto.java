package com.sumbab.sumbab.model.warning;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import java.util.Date;

import org.apache.ibatis.type.Alias;

@Alias("warningDto")
public class WarningDto {

	private int warningNum;
	private int reviewNum;
	private String reason;
	private String reporter;
	private Date regdate;
	
	public int getWarningNum() {
		return warningNum;
	}
	public void setWarningNum(int warningNum) {
		this.warningNum = warningNum;
	}
	public int getReviewNum() {
		return reviewNum;
	}
	public void setReviewNum(int reviewNum) {
		this.reviewNum = reviewNum;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getReporter() {
		return reporter;
	}
	public void setReporter(String reporter) {
		this.reporter = reporter;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
}