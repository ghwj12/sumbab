package com.sumbab.sumbab.model.pick;

import java.util.List;

public interface PickDao {
	
	//보�??��?��  ?��?�� �?게번?�� �??��?���?
	public List<Integer> bringPick(String id);
	
	//보�??��?�� �?게번?�� 추�?
	public void addPick(Pick pick);
	
	
	
	public abstract List<JoinPickVo> joinPickList(String id);
	
	public abstract int pickCount(int store_num);
	
	public abstract StoreVo pickSelect(int store_num); 
	
	public abstract StoreVo StSelect(List result);
	
	public void delPick(Pick vo);
	
}
