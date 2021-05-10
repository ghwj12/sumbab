package com.sumbab.sumbab.model.pick;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PickService {
	
	@Autowired
	private PickDaoImpl pickDao;
	
	public int addPick(String id, int storeNum){
		List<Integer> picked = pickDao.bringPick(id);
		for(int i=0; i<picked.size(); i++) {
			if(picked.get(i) == storeNum) {
				return 1;
			}
		}
		Pick pick = new Pick();
		pick.setId(id);
		pick.setStoreNum(storeNum);
		pickDao.addPick(pick);
		return 0;
	}

	public List<Integer> bringPick(String id){
		return pickDao.bringPick(id);
	}
	
	
	
	
	
	
	public Pick pickList(String id) {
	   
		Pick result = pickDao.pickList(id);
		
		
		return result;
	}
	
	public StoreVo pickRead(int store_num) {
		pickDao.pickCount(store_num);
		
		
		return pickDao.pickSelect(store_num);
	}
	
	
}
