package com.sumbab.sumbab.model.store;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreService {

	public StoreService() {} //기본 생성자
	
	private StoreDaoImpl storeDao;
	
	@Autowired
	public StoreService(StoreDaoImpl storeDao) {
		this.storeDao = storeDao;
	}
	
	public void regist(StoreRegisterRequest req,
				String fullAddress, String extrAddress, String picture) {
		
		int space = fullAddress.indexOf(" ");
		int secspace = fullAddress.indexOf(" ",space+1);
		
		String citycode = fullAddress.substring(0,space);
		String districtcode = fullAddress.substring(space+1,secspace);
		String address = fullAddress.substring(secspace+1)+" "+extrAddress;
		
		Store newStore = new Store(
				req.getClassify(),
				req.getName(),
				citycode,
				districtcode,
				address,
				req.getPhone(),
				req.getMenu(),
				req.getTime(),
				req.getReserving(),
				req.getEtc(),
				req.getPwd(),
				picture);
		storeDao.insert(newStore);
	}
	
	public Store storeView(int storeNum) {
		return storeDao.selectOne(storeNum);
	}
	
	public List<Store> getMyRegitStore(String id){
		return storeDao.myRegitStoreList(id);
	}
	
	public String getClassify(int storeNum) {
		return storeDao.getClassify(storeNum);
	}
	
	public void deleteStore(Store store) {
		storeDao.delete(store);
	}
	
	public void updateStore(Store store) {
		
		if(store.getFullAddress().length()>0) {
			String fullAddress = store.getFullAddress();
			String extrAddress = store.getExtrAddress();
			
			int space = fullAddress.indexOf(" ");
			int secspace = fullAddress.indexOf(" ",space+1);
			String citycode = fullAddress.substring(0,space);
			String districtcode = fullAddress.substring(space+1,secspace);
			String address = fullAddress.substring(secspace+1)+" "+extrAddress;
			
			store.setCitycode(citycode);
			store.setDistrictcode(districtcode);
			store.setAddress(address);
			
			storeDao.update(store);
			
		}else {
			storeDao.update(store);
		}
	}
	
/*	public void upReadCount(int storeNum) {
		storeDao.upReadCount(storeNum);
	}*/
}
