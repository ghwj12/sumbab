package com.sumbab.sumbab.model.member;


public interface MemberService {

	public void memberJoinProcess(MemberVO memberVO);

	public int idCheck(String id);
	
	
}
