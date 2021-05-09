package com.sumbab.sumbab.model.member;

public interface MemberDao {

	public void memberJoinMethod(MemberVO memberVO);

	public int idCheck(String id);
	
	//재학님 회원탈퇴부분 어차피 MemberVo활용해야하니까 여기 만들게용
	public void memberDelete(MemberVO memberVO);
}
