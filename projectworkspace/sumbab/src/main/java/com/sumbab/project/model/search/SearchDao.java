package com.sumbab.project.model.search;

import java.util.List;

import com.sumbab.project.model.store.StoreVo;

public interface SearchDao {

	public List<StoreVo> selectByKeyword(String input); //일반 검색
	public List<StoreVo> selectByTag(String inputT);  //해시태그 검색
	
}
