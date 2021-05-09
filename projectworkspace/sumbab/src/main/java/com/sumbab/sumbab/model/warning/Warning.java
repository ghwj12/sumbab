package com.sumbab.sumbab.model.warning;

import java.util.Date;

import org.apache.ibatis.type.Alias;

@Alias("warning")
public class Warning {

	private int warningNum;
	private int reviewNum;
	private String reporter;
	private String id;
	private Date regdate;
	private String reason;
	private String content;
	
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
	public String getReporter() {
		return reporter;
	}
	public void setReporter(String reporter) {
		this.reporter = reporter;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
