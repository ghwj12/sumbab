package com.sumbab.project.model;

import java.util.List;

public interface PickDao {
	
	//ë³´ê??•¨?—  ?ˆ?Š” ê°?ê²Œë²ˆ?˜¸ ê°?? ¸?˜¤ê¸?
	public List<Integer> bringPick(String id);
	
	//ë³´ê??•¨?— ê°?ê²Œë²ˆ?˜¸ ì¶”ê?
	public void addPick(Pick pick);

}
