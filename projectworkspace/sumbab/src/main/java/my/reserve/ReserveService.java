package my.reserve;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import store.Store;

@Service
public class ReserveService {

	public ReserveService() {}

	private ReserveDaoImpl reserveDao;
	
	@Autowired
	public ReserveService(ReserveDaoImpl reserveDao) {
		this.reserveDao = reserveDao;
	}
	
	public void regit(ReserveRegitReq resReq, String datepicker, String timepicker) {
		String resDate = datepicker+" "+timepicker;
		
		Reserve newReserve = new Reserve(
				resReq.getReserveName(),
				resDate,
				resReq.getPhone()
				);
		reserveDao.insert(newReserve);
	}
	
	public List<Reserve> getListF(String memberID) {
		return reserveDao.listFuture(memberID);
	}
	
	public List<Reserve> getListP(String memberID) {
		return reserveDao.listPast(memberID);
	}
	
	public List<Store> getStoreName(String memberID){
		return reserveDao.getStoreName(memberID);
	}
}
