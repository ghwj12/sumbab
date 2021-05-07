package com.sumbab.sumbab.model.reserve;

import java.util.List;


import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sumbab.sumbab.model.store.Store;



@Repository
public class ReserveDaoImpl implements ReserveDao {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Autowired
	public ReserveDaoImpl(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	//예약내역 리스트 가져오기
	@Override
	public List<Reserve> listFuture(String memberID) {
		List<Reserve> results = sqlSessionTemplate.selectList("listFuture", memberID);
		
		return results;
	}
	//예약내역 리스트 가져오기
	@Override
	public List<Reserve> listPast(String memberID) {
		List<Reserve> results = sqlSessionTemplate.selectList("listPast", memberID);
		
		return results;
	}

	//예약내역 삭제하기(취소하기) 현재 시간 기준으로 취소 가능 여부 결정
	@Override
	public void delete(int reserveSeq) {
		sqlSessionTemplate.delete("deleteReserve", reserveSeq);
	}

	@Override
	public void insert(Reserve reserve) {
		sqlSessionTemplate.insert("insertReserve", reserve);
	}

	@Override
	public List<Store> getStoreName(String memberID) {
		return sqlSessionTemplate.selectList("getStoreName", memberID);
	}

	@Override
	public String getID(Reserve reserve) {
			
		return sqlSessionTemplate.selectOne("getID", reserve);
	}

}
