package com.sumbab.project.model;

import java.util.List;

public interface WarningDao {

	//신고 내역
	public List<Warning> allReport();
	
	//신고 상세보기
	public WarningVo reportDetail(int warningNum);
	
	//classify 변경
	public void changeClassify(ChangeClassifyDto classifyDto);
	
	//신고 삭제
	public void delete(int warningNum);
	
}
