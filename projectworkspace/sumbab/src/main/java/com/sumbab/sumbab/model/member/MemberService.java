package com.sumbab.sumbab.model.member;


public interface MemberService {

	public void memberJoinProcess(MemberJVO memberVO);

	public int idCheck(String id);
	
	
}
