package my.reserve;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReserveService {

	public ReserveService() {}

	private ReserveDaoImpl reserveDao;
	
	@Autowired
	public ReserveService(ReserveDaoImpl reserveDao) {
		this.reserveDao = reserveDao;
	}
	
	public void alignValue(ReserveRegitReq resReq, String datepicker, String timepicker) {
		String resDate = datepicker+" "+timepicker+":00";
		System.out.println(resDate);//확인용
		
		Reserve newReserve = new Reserve(
				resReq.getReserveName(),
				resDate,
				resReq.getPhone()
				);
		
		reserveDao.insert(newReserve);
	}
	
}
