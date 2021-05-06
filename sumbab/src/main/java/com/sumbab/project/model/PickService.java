package com.sumbab.project.model;

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
	
}
