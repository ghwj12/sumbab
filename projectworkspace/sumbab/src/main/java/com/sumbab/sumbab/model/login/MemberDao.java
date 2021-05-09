package com.sumbab.sumbab.model.login;

import java.util.Map;

public interface MemberDao {

	
	
	public abstract void insert(MemberVo vo);
	public abstract boolean select(MemberVo vo);
	public abstract MemberVo select2(MemberVo vo);
	public abstract MemberVo idFind(MemberVo vo);
	public abstract MemberVo pwdFind(MemberVo vo);
	public abstract void kaLoginInsert(Map<String, Object> map);
	public abstract boolean kaLoginSelect(Map<String, Object> map);
	public abstract MemberVo kaLoginSelect2(Map<String, Object> map);
	//정민
	public void memberDelete(MemberVo memberVO);
	
}
