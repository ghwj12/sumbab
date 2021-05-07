package com.sumbab.sumbab.model.warning;

import java.util.List;

import com.sumbab.sumbab.model.classify.ChangeClassifyDto;
import com.sumbab.sumbab.model.classify.MemberClassify;

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
	public List<MemberClassify> selectMember();
	
	//?���? ?��?��
	public void updateMemberClassify(String id);
	
}
