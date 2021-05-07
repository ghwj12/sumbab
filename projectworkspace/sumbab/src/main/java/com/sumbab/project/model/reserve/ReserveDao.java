package com.sumbab.project.model.reserve;

import java.util.List;

import org.apache.catalina.Store;

import com.sumbab.project.model.StoreVo;

public interface ReserveDao {

	public void insert(Reserve reserve);//예약하기
	public void delete(int reserveSeq); //예약 삭제(예약시간 1시간 전까지만. 별도 수정 없이 취소만 가능)
	
	public List<Reserve> listFuture(String memberID); //memberVO.id로 예약리스트 가져오기
	public List<Reserve> listPast(String memberID); //memberVO.id로 예약리스트 가져오기
	
	public List<StoreVo> getStoreName(String memberID);
	
	public String getID(Reserve reserve);
}
