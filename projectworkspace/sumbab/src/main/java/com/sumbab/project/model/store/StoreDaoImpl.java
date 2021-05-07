package com.sumbab.project.model.store;

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
	public void insert(StoreVo store) {
		sqlSessionTemplate.insert("insertStore", store);
	}

	@Override
	public void update(StoreVo store) {
		sqlSessionTemplate.update("updateStore", store);
	}

	@Override
	public void delete(StoreVo store) {
		sqlSessionTemplate.delete("deleteStore", store);
	}

	@Override // 숨밥 시작하기 : 카테고리 검색-식당
	public List<StoreVo> selectByRestCat(String category) {
		List<StoreVo> results = sqlSessionTemplate.selectList("selectByRestCat", category);
		return results;
	}

	@Override // 숨밥 시작하기 : 카테고리 검색-식당
	public List<StoreVo> selectByCafeCat(String category) {
		List<StoreVo> results = sqlSessionTemplate.selectList("selectByCafeCat", category);
		return results;
	}

	@Override //가게 리스트 --->가게 상세보기 (storeNum)으로 select
	public StoreVo selectOne(int storeNum) {
		
		return sqlSessionTemplate.selectOne("storeView", storeNum);
	}

	@Override
	public void upReadCount(int storeNum) {
		sqlSessionTemplate.update("upReadCount", storeNum);
	}
}
