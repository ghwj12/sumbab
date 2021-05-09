package com.sumbab.sumbab.model.warning;

import java.util.List;

import com.sumbab.sumbab.model.classify.ChangeClassifyDto;
import com.sumbab.sumbab.model.classify.MemberClassify;

public interface WarningDao {

	//신고 내역
	public List<Warning> allReport();
	
	//신고 상세보기
	public Warning reportDetail(int warningNum);
	
	//classify 변경
	public void changeClassify(ChangeClassifyDto classifyDto);
	
	//신고 삭제
	public void delete(int warningNum);
	
	//신고 접수
	public void insert(Warning warningDto);
	
	//정지 계정 가져오기
	public List<MemberClassify> selectMember();
	
	//정지 해제
	public void updateMemberClassify(String id);
	
}
