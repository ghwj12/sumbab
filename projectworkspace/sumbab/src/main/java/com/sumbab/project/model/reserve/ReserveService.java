package com.sumbab.project.model.reserve;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sumbab.project.model.StoreVo;

@Service
public class ReserveService {

	public ReserveService() {}

	private ReserveDaoImpl reserveDao;
	
	@Autowired
	public ReserveService(ReserveDaoImpl reserveDao) {
		this.reserveDao = reserveDao;
	}
	
	public void regit(ReserveRegitReq resReq, String datepicker, String timepicker, HttpSession session, int storeNum) {
		String resDate = datepicker+" "+timepicker;
		//세션 memberVO.id 값 임시 지정
		String id = "deliciousman";
		session.setAttribute("id", session.getAttribute(id));
		
		Reserve newReserve = new Reserve(
				storeNum,
				id,
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
	
	public List<StoreVo> getStoreName(String memberID){
		return reserveDao.getStoreName(memberID);
	}
	
	public void delete(int reserveSeq) {
		reserveDao.delete(reserveSeq);
	}
	
}
