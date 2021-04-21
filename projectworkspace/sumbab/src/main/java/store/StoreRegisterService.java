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
	
	public void regist(StoreRegisterRequest req) {

		Store newStore = new Store(
				req.getClassify(),
				req.getName(),
				req.getAddress(),
				req.getPhone(),
				req.getMenu(),
				req.getTime(),
				req.getReserving(),
				req.getEtc(),
				req.getPwd());
		
		storeDao.insert(newStore);
	}
}
