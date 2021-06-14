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
	
	
	
	
	
	public List<JoinPickVo> pickList(String id) {
		   
		
		
	
		
//		List result = (List) pickDao.pickList(id);
//		 
//		StoreVo result2 = pickDao.StSelect(result);
		
		
		
		return pickDao.joinPickList(id); 
	}

	
	public StoreVo pickRead(int store_num) {
		
		pickDao.pickCount(store_num);
		
		
		return pickDao.pickSelect(store_num);
	}
	
	
	public void delPick(Pick vo) {
		pickDao.delPick(vo);
	}
		
}
