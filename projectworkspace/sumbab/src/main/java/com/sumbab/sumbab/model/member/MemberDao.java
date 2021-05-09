package com.sumbab.sumbab.model.member;



public interface MemberDao {

	public void memberJoinMethod(MemberVO memberVO);

	public int idCheck(String id);
	

	
}
