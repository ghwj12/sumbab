package store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreRegisterService {

	public StoreRegisterService() {} //기본 생성자
	
	private StoreDaoImpl storeDao;
	
	@Autowired
	public StoreRegisterService(StoreDaoImpl storeDao) {
		this.storeDao = storeDao;
	}
	
	public void regist(StoreRegisterRequest req, String fullAddress, String extrAddress) {
		
		int space = fullAddress.indexOf(" ");
		int secspace = fullAddress.indexOf(" ",space+1);
		
		String cityCode = fullAddress.substring(0,space);
		String districtCode = fullAddress.substring(space+1,secspace);
		String address = fullAddress.substring(secspace+1)+" "+extrAddress;
		
		Store newStore = new Store(
				req.getClassify(),
				req.getName(),
				cityCode,
				districtCode,
				address,
				req.getPhone(),
				req.getMenu(),
				req.getTime(),
				req.getReserving(),
				req.getEtc(),
				req.getPwd());
		
		storeDao.insert(newStore);
	}
}
