package com.sumbab.sumbab.model.store;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StoreDaoImpl implements StoreDao {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Autowired
	public StoreDaoImpl(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	// =========기본 CRUD 기능================
	@Override
	public void insert(Store store) {
		sqlSessionTemplate.insert("insertStore", store);
	}

	@Override
	public void update(Store store) {
		sqlSessionTemplate.update("updateStore", store);
	}

	@Override
	public void delete(Store store) {
		sqlSessionTemplate.delete("deleteStore", store);
	}

	@Override //가게 관리자 : 등록한 가게 모아보기
	public List<Store> myRegitStoreList(String id) {
		return sqlSessionTemplate.selectList("myRegitStoreList", id);
	}
	
	@Override // 숨밥 시작하기 : 카테고리 검색-식당
	public List<Store> selectByRestCat(String category) {
		List<Store> results = sqlSessionTemplate.selectList("selectByRestCat", category);
		return results;
	}

	@Override // 숨밥 시작하기 : 카테고리 검색-식당
	public List<Store> selectByCafeCat(String category) {
		List<Store> results = sqlSessionTemplate.selectList("selectByCafeCat", category);
		return results;
	}

	@Override //가게 리스트 --->가게 상세보기 (storeNum)으로 select
	public Store selectOne(int storeNum) {
		
		return sqlSessionTemplate.selectOne("storeView", storeNum);
	}

	@Override
	public void upReadCount(int storeNum) {
		sqlSessionTemplate.update("upReadCount", storeNum);
	}

	@Override
	public String getClassify(int storeNum) {
		return sqlSessionTemplate.selectOne("getStoreClassify", storeNum);
	}

}
