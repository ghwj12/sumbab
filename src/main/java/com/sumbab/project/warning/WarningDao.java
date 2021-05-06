package com.sumbab.project.warning;

import java.util.List;

public interface WarningDao {

	//신고 내역
	public List<WarningVo> allReport();
	
	//신고 상세보기
	public WarningVo reportDetail(int warningNum);
	
	//classify 변경
	public void changeClassify(ChangeClassifyDto classifyDto);
	
	//신고 삭제
	public void delete(int warningNum);
	
	//신고 접수
	public void insert(WarningDto warningDto);
	
	//정지 계정 가져오기
	public List<MemberClassifyVo> selectMember();
	
	//정지 해제
	public void updateMemberClassify(String id);
	
}