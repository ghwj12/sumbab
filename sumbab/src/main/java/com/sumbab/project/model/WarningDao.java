package com.sumbab.project.model;

import java.util.List;

public interface WarningDao {

	//?ã†Í≥? ?Ç¥?ó≠
	public List<WarningVo> allReport();
	
	//?ã†Í≥? ?ÉÅ?Ñ∏Î≥¥Í∏∞
	public WarningVo reportDetail(int warningNum);
	
	//classify Î≥?Í≤?
	public void changeClassify(ChangeClassifyDto classifyDto);
	
	//?ã†Í≥? ?Ç≠?†ú
	public void delete(int warningNum);
	
	//?ã†Í≥? ?†ë?àò
	public void insert(WarningDto warningDto);
	
	//?†ïÏß? Í≥ÑÏ†ï Í∞??†∏?ò§Í∏?
	public List<MemberClassifyVo> selectMember();
	
	//?†ïÏß? ?ï¥?†ú
	public void updateMemberClassify(String id);
	
}
