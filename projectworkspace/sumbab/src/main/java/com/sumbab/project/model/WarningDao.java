package com.sumbab.project.model;

import java.util.List;

public interface WarningDao {

	//?���? ?��?��
	public List<WarningVo> allReport();
	
	//?���? ?��?��보기
	public WarningVo reportDetail(int warningNum);
	
	//classify �?�?
	public void changeClassify(ChangeClassifyDto classifyDto);
	
	//?���? ?��?��
	public void delete(int warningNum);
	
	//?���? ?��?��
	public void insert(WarningDto warningDto);
	
	//?���? 계정 �??��?���?
	public List<MemberClassifyVo> selectMember();
	
	//?���? ?��?��
	public void updateMemberClassify(String id);
	
}
